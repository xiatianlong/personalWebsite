package com.personalWebsite.common.mail;

import freemarker.template.Template;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.mail.internet.MimeMessage;
import java.util.Set;

/**
 * Created by xiatianlong on 2017/12/16.
 */
@Component
public class MailSender {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private SimpleMailMessage simpleMailMessage;

    @Autowired
    protected FreeMarkerConfigurer mailTemplate;

    /**
     * 日志
     */
    private Logger log = Logger.getLogger(this.getClass());

    /**
     * 发送邮件
     *
     * @param mailInfo 邮件信息
     */
    public boolean sendMail(MailInfo mailInfo) {

        // 邮件发送成功与否标志位
        boolean isSuccess = false;
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;
        try {
            mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

            // 邮件发送方
            mimeMessageHelper.setFrom(simpleMailMessage.getFrom());

            // 邮件接受方
            if (!StringUtils.isEmpty(mailInfo.getTo())) {
                mimeMessageHelper.setTo(mailInfo.getTo());
            } else {
                Set<String> toList = mailInfo.getToList();
                if (toList != null && !toList.isEmpty()) {
                    mimeMessageHelper.setTo(toList.toArray(new String[toList.size()]));
                }
            }

            // 邮件标题
            if (!StringUtils.isEmpty(mailInfo.getSubject())) {
                mimeMessageHelper.setSubject(mailInfo.getSubject());
            } else {
                mimeMessageHelper.setSubject(simpleMailMessage.getSubject());
            }

            // 邮件文本
            if (!StringUtils.isEmpty(mailInfo.getTemplateName())) {
                // 获取模板
                Template temp = mailTemplate.getConfiguration().getTemplate(mailInfo.getTemplateName());
                // 通过模版和参数获取内容
                String content = FreeMarkerTemplateUtils.processTemplateIntoString(temp, mailInfo.getArguments());
                mimeMessageHelper.setText(content, true);
            } else {
                mimeMessageHelper.setText(mailInfo.getContent(), true);
            }

            // 附件集合
            if (mailInfo.getAttachments() != null && mailInfo.getAttachments().iterator().hasNext()) {
                for (MailAttachment attachment : mailInfo.getAttachments()) {
                    mimeMessageHelper.addAttachment(attachment.getName(), new UrlResource(attachment.getUrl()));
                }
            }
            javaMailSender.send(mimeMessage);

            if (log.isDebugEnabled()) {
                log.debug("The mail sent successfully." + System.getProperty("line.separator") + mimeMessage);
            } else {
                log.info("The mail sent successfully." + System.getProperty("line.separator") + "Subject: " + mailInfo.getSubject()
                        + System.getProperty("line.separator")
                        + "To: " + (!StringUtils.isEmpty(mailInfo.getTo()) ? mailInfo.getTo() : mailInfo.getToList().toString()));
            }

            isSuccess = true;

        } catch (Exception e) {
            isSuccess = false;
            // do nothing
            e.printStackTrace();
        }

        return isSuccess;
    }

}
