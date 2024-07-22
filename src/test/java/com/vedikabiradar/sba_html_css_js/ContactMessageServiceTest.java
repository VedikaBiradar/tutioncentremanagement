package com.vedikabiradar.sba_html_css_js;

import com.vedikabiradar.sba_html_css_js.Entity.ContactMessage;
import com.vedikabiradar.sba_html_css_js.Repository.ContactMessageRepository;
import com.vedikabiradar.sba_html_css_js.Service.ContactMessageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ContactMessageServiceTest {

    @Autowired
    private ContactMessageService contactMessageService;

    @Autowired
    private ContactMessageRepository contactMessageRepository;



    @Test
    public void testSaveMessage() {
        // Given
        ContactMessage message = new ContactMessage("John Doe", "john.doe@example.com", "1234567890", "This is a message.");

        // When
        contactMessageService.saveMessage(message);

        // Then
        ContactMessage savedMessage = contactMessageRepository.findById(message.getId()).orElse(null);
        assertNotNull(savedMessage, "This is a message.");
        assertEquals("John Doe", savedMessage.getFullname());
        assertEquals("john.doe@example.com", savedMessage.getEmail());
        assertEquals("1234567890", savedMessage.getPhone());
        assertEquals("This is a message.", savedMessage.getMessage());
    }
}
