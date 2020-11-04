package com.qiding.jiaguo.mail;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class SendEmailUtil {


    public static Boolean sendEmail(JMailConfig jmailConfig, JMailData jMailData)  throws EmailException {
		HtmlEmail email=new HtmlEmail();//创建电子邮件对象
		email.setDebug(true);
		email.setSSLCheckServerIdentity(true);
		email.setSmtpPort(465);
		email.setSSLOnConnect(true);
		email.setHostName(jmailConfig.getHost());//设置发送电子邮件使用的服务器主机名
		email.setAuthenticator(new DefaultAuthenticator(jmailConfig.getUserName(), jmailConfig.getPassword()));//邮件服务器身份验证
		email.setFrom(jmailConfig.getUserName());//设置发信人邮箱
		email.setSubject(jMailData.getTitle());//设置邮件主题
		email.setMsg(jMailData.getContent());//设置邮件文本内容
		email.addTo(jMailData.getReceiver());//设置收件人
//		EmailAttachment attach =new EmailAttachment();//附件对象
//		attach.setPath("C:/temp/wenzhi.doc");//附件文件在系统中的路径
//		attach.setDescription(EmailAttachment.ATTACHMENT);
//		email.attach(attach);//添加附件
		email.send();//发送邮件
		return Boolean.TRUE;
	}


//	public static void main(String[] args) {
//		try {
//			sendEmail();
//		} catch (EmailException e) {
//			e.printStackTrace();
//		}
//	}
}
