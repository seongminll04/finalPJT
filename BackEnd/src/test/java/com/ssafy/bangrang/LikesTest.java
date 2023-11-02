package com.ssafy.bangrang;

import com.ssafy.bangrang.domain.event.entity.Event;
import com.ssafy.bangrang.domain.event.repository.EventRepository;
import com.ssafy.bangrang.domain.member.entity.AppMember;
import com.ssafy.bangrang.domain.member.entity.AppMemberStamp;
import com.ssafy.bangrang.domain.member.entity.Stamp;
import com.ssafy.bangrang.domain.member.entity.WebMember;
import com.ssafy.bangrang.domain.member.service.AppMemberService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
public class LikesTest {

    @PersistenceContext
    EntityManager em;

    @Autowired
    AppMemberService appMemberService;

    @Autowired
    EventRepository eventRepository;

    @BeforeEach
    void beforeEach(){
        AppMember appMember = AppMember.builder()
                .id("appMember1")
                .build();
        em.persist(appMember);
        WebMember webMember = WebMember.builder()
                .id("webMember1")
                .build();
        em.persist(webMember);
        Event event = Event.builder()
                .title("title")
                .webMember(webMember)
                .build();
        em.persist(event);

    }

    @Test
    void addLikesTest(){
        AppMember appMember = appMemberService.findById("appMember1").orElseThrow();
        Event event = eventRepository.findById((long) 1).orElseThrow();

    }
}
