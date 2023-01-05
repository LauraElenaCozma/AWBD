package com.awbd.lab6;

import com.awbd.lab6.services.ProductService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductsControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ProductService productService;

    @MockBean
    Model model;

//    @Disabled
//    @Test
//    public void showByIdMvc() throws Exception {
//        mockMvc.perform(get("/product/info/{id}"), "1"))
//        .andExpect(status().isOk());
//    }
}
