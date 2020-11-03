package com.qiding.jiaguo.service;

import com.qiding.jiaguo.mail.JMailConfig;
import com.qiding.jiaguo.mail.JMailData;
import com.qiding.jiaguo.mail.MailActiveCode;
import com.qiding.jiaguo.mail.SendEmailUtil;
import com.qiding.jiaguo.util.GenerateRedisKeyUtil;
import com.qiding.jiaguo.util.JiaGuoRandomUtil;
import com.qiding.jiaguo.controller.request.VerifySmsCode;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Log4j2
@Data
public class JMailService {

    private String emailTemplate;

    private Integer activeCodeLength;

    @Autowired
    private JMailConfig jMailConfig;

    @Autowired
    RestTemplate restTemplate;


    public void sendActiveSmsCode(String receiver) {
        String activeCode = JiaGuoRandomUtil.generateCode(activeCodeLength);
        MailActiveCode mailActiveCode = MailActiveCode.builder()
                .activeCode(activeCode)
                .receiver(receiver)
                .build();

        ResponseEntity response = restTemplate.postForEntity("http://QIDING-JIAGUO-CACHE/cacheKeyWithEx?key={key}&cacheTime={cacheTime}",
                mailActiveCode, Void.class, GenerateRedisKeyUtil.geneRateActiveCode(receiver) , 1000 * 60 * 3);
        if (response.getStatusCode() != HttpStatus.OK) {
            log.error("发送验证码失败,receiver={},response={}", receiver, response);
            return;
        }
        String content = String.format(emailTemplate, receiver, activeCode);
        JMailData jMailData = JMailData.builder().content(content).receiver(receiver).build();
        try {
            SendEmailUtil.sendEmail(jMailConfig, jMailData);
        } catch (EmailException e) {
            e.printStackTrace();
            log.error("发送激活邮件失败,receiver={},config={},data={}", receiver, jMailConfig, jMailData, e);
        }
    }


    public Boolean verifySmsCode(VerifySmsCode verifySmsCode) {
        String className = MailActiveCode.class.getName();
        MailActiveCode activeCode = restTemplate.getForObject("http://QIDING-JIAGUO-CACHE/getValue?key={key}&className={className}"
                , MailActiveCode.class, GenerateRedisKeyUtil.geneRateActiveCode(verifySmsCode.getUserEmail()), className);
        return verifySmsCode.getSmsCode().equals(Optional.ofNullable(activeCode)
                .orElse(new MailActiveCode()).getActiveCode());
    }


}
