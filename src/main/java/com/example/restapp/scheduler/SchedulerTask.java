package com.example.restapp.scheduler;


import com.example.restapp.entity.Element;
import com.example.restapp.service.ElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


import java.util.Date;
import java.util.List;

@Component
public class SchedulerTask {

    @Autowired
    ElementService elementService;
    Date date=new Date();
    Date ago=new Date();

    List<Element>elementList;

    @Scheduled(fixedRate = 1000*60*60)
    public void scheduleTaskWithFixedRate() {
        ago.setHours(date.getHours()-1);
        elementList=elementService.lastHour(ago);
        if (!elementList.isEmpty()){
            System.out.println("for last hour was added few elements");
            for (Element e:elementList) {
                System.out.println(e+" Id-"+e.getId()+", Name-"+e.getName()+", date of add-"+e.getAddedDate());
            }
        }else {
            System.out.println("nothing was added for last hour");
        }
    }

}
