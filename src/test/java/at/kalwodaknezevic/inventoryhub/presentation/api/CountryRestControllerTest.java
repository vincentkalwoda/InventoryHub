package at.kalwodaknezevic.inventoryhub.presentation.api;

import at.kalwodaknezevic.inventoryhub.service.CountryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static at.kalwodaknezevic.inventoryhub.FixturesFactory.austria;
import static org.assertj.core.api.Assumptions.assumeThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CountryRestController.class)
class CountryRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private CountryService countryService;


    @BeforeEach
    void setUp() {
        assumeThat(countryService).isNotNull();
        assumeThat(mockMvc).isNotNull();
    }

    @Test
    void getAllCountries_returnsListOfCountries() throws Exception {
        var request = get("/api/countries").accept(MediaType.APPLICATION_JSON);
        when(countryService.getAll()).thenReturn(List.of(austria()));

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name").value("Austria"))
                .andExpect(jsonPath("$[0].iso2Code").value("AT"))
                .andExpect(jsonPath("$[0].iso3Code").value("AUT"))
                .andExpect(jsonPath("$[0].areaCode").value(43))
                .andDo(print());
    }

}