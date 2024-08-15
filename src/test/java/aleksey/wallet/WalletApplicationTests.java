package aleksey.wallet;

import aleksey.wallet.controller.impl.WalletControllerImpl;
import aleksey.wallet.dto.WalletRequest;
import aleksey.wallet.dto.WalletResponse;
import aleksey.wallet.service.WalletService;
import aleksey.wallet.status_operation.Operation;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(WalletControllerImpl.class)
class WalletApplicationTests {

    @Autowired
    private MockMvc mvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private WalletService service;



    @Test
    public void updateBalance_thenStatus200() throws Exception {
        WalletRequest wallet = WalletRequest.builder()
                .valetId(UUID.fromString("35132472-c7f9-4723-9be4-21728a493aba"))
                .operationType(Operation.DEPOSIT)
                .amount(1000)
                .build();
        mvc.perform(post("/api/v1/wallet")
                        .content(objectMapper.writeValueAsString(wallet))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getBalance_thenStatus200() throws Exception {
        WalletResponse wallet = WalletResponse.builder().balance(1000L).build();
        Mockito.when(service.getBalance(UUID.fromString("35132472-c7f9-4723-9be4-21728a493aba")))
                .thenReturn(wallet);
        mvc.perform(get("/api/v1/wallets/35132472-c7f9-4723-9be4-21728a493aba")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.balance").value(1000L));

    }

}
