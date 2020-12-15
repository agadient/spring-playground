package com.example.demo;


import org.junit.Test;
        import org.junit.runner.RunWith;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.test.context.SpringBootTest;
        import org.springframework.http.HttpMethod;
        import org.springframework.http.MediaType;
        import org.springframework.test.context.junit4.SpringRunner;
        import org.springframework.test.web.client.MockRestServiceServer;
        import org.springframework.web.client.RestTemplate;

        import static org.hamcrest.MatcherAssert.assertThat;
        import static org.hamcrest.core.IsEqual.equalTo;
        import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
        import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RunWith(SpringRunner.class)
public class MoviesTest {

    @Test
    public void getRequestWorks() {
        MoviesService service = new MoviesService();

        // #1 - mock the correct instance
        MockRestServiceServer mockServer = MockRestServiceServer.createServer(service.getRestTemplate());

        mockServer
                .expect(requestTo("https://api.github.com/zen"))                // <-- #2
                .andExpect(method(HttpMethod.GET))                              // <-- #3
                .andRespond(withSuccess("FooBar", MediaType.APPLICATION_JSON)); // <-- #4

        assertThat(service.getMovies("harry"), equalTo("FooBar"));                    // <-- #5
        mockServer.verify();                                                    // <-- #6
    }

}