package whz.pti.eva.gradeCalculator;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import whz.pti.eva.gradeCalculator.grade.domain.Grade;
import whz.pti.eva.gradeCalculator.grade.service.GradeService;

@SpringBootTest //(classes = GradeCalculatorBaitakovaStraesser.class) //(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode=ClassMode.AFTER_CLASS)
class GradeControllerTest {

	@Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;
    
    @MockBean private GradeService gradeServiceMock; 
    
    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(wac)
                .build();
        when(gradeServiceMock.listAllGrades()).thenReturn(List.of(new Grade("foo","1.3"),new Grade("bar", "3.7")));
    }
    
    @Test
    public void testListAllGrades() throws Exception {
        mockMvc.perform(get("/grades"))
        		.andExpect(status().isOk())
        		.andExpect(view().name("grades"))
        		.andExpect(model().attribute("listAllGrades", hasSize(2)))
        		.andDo(print());
    }
}
