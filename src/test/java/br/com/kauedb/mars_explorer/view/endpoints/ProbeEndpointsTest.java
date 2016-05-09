package br.com.kauedb.mars_explorer.view.endpoints;

import br.com.kauedb.mars_explorer.test.IntegrationTest;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

/**
 *
 */
public class ProbeEndpointsTest extends IntegrationTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Before
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();
    }

    @Test
    public void shouldMovedProbe() throws Exception {
        mvc.perform(post("/probes/1/command").content("{\"movements\":\"MRMLM\"}"))
                .andExpect(jsonPath("$.position.x", is(0)))
                .andExpect(jsonPath("$.position.y", is(3)))
        ;
    }

}
