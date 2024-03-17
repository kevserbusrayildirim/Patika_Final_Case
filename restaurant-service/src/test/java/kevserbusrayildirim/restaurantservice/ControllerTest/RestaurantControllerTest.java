package kevserbusrayildirim.restaurantservice.ControllerTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import kevserbusrayildirim.restaurantservice.controller.RestaurantController;
import kevserbusrayildirim.restaurantservice.controller.contract.RestaurantControllerContract;
import kevserbusrayildirim.restaurantservice.dto.RestaurantDto;
import kevserbusrayildirim.restaurantservice.model.request.RecommendRequest;
import kevserbusrayildirim.restaurantservice.model.request.RestaurantRequest;
import kevserbusrayildirim.restaurantservice.model.response.RecommendResponse;
import kevserbusrayildirim.restaurantservice.model.response.RestaurantSolrResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class RestaurantControllerTest {

    private MockMvc mockMvc;

    @Mock
    private RestaurantControllerContract restaurantControllerContract;

    @InjectMocks
    private RestaurantController restaurantController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(restaurantController).build();
    }

    @Test
    public void testGetAllRestaurants() throws Exception {
        when(restaurantControllerContract.getAllRestaurants()).thenReturn(new RestaurantSolrResponse());

        mockMvc.perform(get("/restaurants"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        verify(restaurantControllerContract, times(1)).getAllRestaurants();
        verifyNoMoreInteractions(restaurantControllerContract);
    }

    @Test
    public void testCreateRestaurant() throws Exception {
        RestaurantRequest restaurantRequest = new RestaurantRequest();
        restaurantRequest.setName("Test Restaurant");

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonRequest = objectMapper.writeValueAsString(restaurantRequest);

        when(restaurantControllerContract.createRestaurant(any())).thenReturn(new RestaurantDto());

        mockMvc.perform(post("/restaurants/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        verify(restaurantControllerContract, times(1)).createRestaurant(any());
        verifyNoMoreInteractions(restaurantControllerContract);
    }

    @Test
    public void testRecommendedRestaurants() throws Exception {
        RecommendRequest recommendRequest = new RecommendRequest();

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonRequest = objectMapper.writeValueAsString(recommendRequest);

        when(restaurantControllerContract.recommendedRestaurants(any())).thenReturn(new RecommendResponse());

        mockMvc.perform(post("/restaurants")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        verify(restaurantControllerContract, times(1)).recommendedRestaurants(any());
        verifyNoMoreInteractions(restaurantControllerContract);
    }

    @Test
    public void testUpdateRestaurant() throws Exception {
        String restaurantId = "1";
        RestaurantDto restaurantDto = new RestaurantDto();
        restaurantDto.setId(restaurantId);
        restaurantDto.setName("New Side Restaurant");
        restaurantDto.setAddress("Los Angeles");
        restaurantDto.setScore("FIVE");
        restaurantDto.setLatitude("34.0549");
        restaurantDto.setLongitude("118.2426");

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonRequest = objectMapper.writeValueAsString(restaurantDto);

        when(restaurantControllerContract.updateRestaurant(eq(restaurantId), any())).thenReturn(restaurantDto);

        mockMvc.perform(put("/restaurants/{restaurantId}/update", restaurantId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        verify(restaurantControllerContract, times(1)).updateRestaurant(eq(restaurantId), any());
        verifyNoMoreInteractions(restaurantControllerContract);
    }

    @Test
    public void testDeleteRestaurant() throws Exception {
        String restaurantId = "1";

        mockMvc.perform(delete("/restaurants/{restaurantId}", restaurantId))
                .andExpect(status().isNoContent());

        verify(restaurantControllerContract, times(1)).deleteRestaurant(eq(restaurantId));
        verifyNoMoreInteractions(restaurantControllerContract);
    }
}
