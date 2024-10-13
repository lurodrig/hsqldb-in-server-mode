package com.example.hsqldb_in_server_mode;

import com.example.hsqldb_in_server_mode.business.Account;
import com.example.hsqldb_in_server_mode.business.AccountRepository;
import com.example.hsqldb_in_server_mode.web.AccountController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(value = AccountController.class)
public class HsqldbInServerModeWebMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountRepository accountRepository;

    @Test
    public void accountSummary() throws Exception {

        List<Account> mockedListOfAccounts = List.of(new Account("123456789", "John Doe"));
        given(accountRepository.findAll()).willReturn(mockedListOfAccounts);

        mockMvc.perform(get("/accounts"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$..number").value("123456789"))
                .andExpect(jsonPath("$..name").value("John Doe"));

        verify(accountRepository).findAll();
    }

}
