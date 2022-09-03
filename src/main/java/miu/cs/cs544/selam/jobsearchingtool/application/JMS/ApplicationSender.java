package miu.cs.cs544.selam.jobsearchingtool.application.JMS;


import miu.cs.cs544.selam.jobsearchingtool.application.model.Application;
import miu.cs.cs544.selam.jobsearchingtool.application.model.ApplicationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;

import java.net.http.HttpRequest;
import java.util.HashMap;
import java.util.Map;

@Component
public class ApplicationSender {

    @Autowired
    private JmsTemplate jmsTemplate;
    @Value(value = "${springjms.cs544FinalBroker}")
    private String queueName;

    public void requestSender(String method, ApplicationDTO application, int id) {
        Map<String, Object> map = new HashMap<>();
        map.put("request", true);
        map.put("method", method);
        map.put("data.jobId", application.getJobId());
        map.put("data.date", application.getDate());
        map.put("data.resumeVersion", application.getResumeVersion());
        map.put("id", id);
        jmsTemplate.convertAndSend(queueName, map);
    }

    public void responseSender(Object data) {
        Map<String, Object> map = new HashMap<>();
        map.put("response", true);
        map.put("data", data);
        jmsTemplate.convertAndSend(queueName, map);
        System.out.println("Response from application server sent!");
    }

}
