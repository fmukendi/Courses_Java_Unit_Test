Annotations
-----

* (1) ``` @InjectMocks @Mock @RunWith```

```java
// Let's now migrate a test that uses a JUnit4-based runner to JUnit5.

// We're going to use a Spring test as an example:

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SpringTestConfiguration.class })
public class GreetingsSpringTest {
    // ...
}
// If we want to migrate this test to JUnit5 we need to replace the @RunWith annotation with the new @ExtendWith:

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { SpringTestConfiguration.class })
public class GreetingsSpringTest {
    // ...
}
// The SpringExtension class is provided by Spring 5 and integrates the Spring TestContext Framework into JUnit 5. The @ExtendWith annotation accepts // any class that implements the Extension interface.

```java
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@RunWith(MockitoJUnitRunner.class)
class SomeBusinessImplMockTest {

    @InjectMocks
    private SomeBusinessImpl someBusiness;

    @Mock
    private SomeDataService someDataServiceMock;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void calculateSum_basic() {

        when(someDataServiceMock.retrieveAllData()).thenReturn(new int[]{1, 2, 3});
        assertEquals(someBusiness.calculateSumWithDataService(), 6);
    }


    @Test
    public void calculateSum_empty() {

        when(someDataServiceMock.retrieveAllData()).thenReturn(new int[]{});

        int actuarResult = someBusiness.calculateSumWithDataService();
        int expectedResult = 0;
        assertEquals(actuarResult, expectedResult);
    }
}

```


* (2) ``` @Mock```
```java
@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class SomeBusinessImplMockTest {
    @InjectMocks
    private SomeBusinessImpl someBusiness;

    @Mock
    private SomeDataService someDataServiceMock;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void calculateSum_basic() {

        when(someDataServiceMock.retrieveAllData()).thenReturn(new int[]{1, 2, 3});
        assertEquals(someBusiness.calculateSumWithDataService(), 6);
    }


    @Test
    public void calculateSum_empty() {

        when(someDataServiceMock.retrieveAllData()).thenReturn(new int[]{});

        int actuarResult = someBusiness.calculateSumWithDataService();
        int expectedResult = 0;
        assertEquals(actuarResult, expectedResult);
    }
}

```

* (2) ``` @DataJpaTest```
```java

@DataJpaTest
@RunWith(SpringRunner.class)
public class ItemRepositoryTest {

    @Autowired
    ItemRepository itemRepository;

    @Test
    public void testFindAll(){
        List<Item> items = itemRepository.findAll();

        assertEquals(3, items.size());
    }
}

```


* (3) ``` @WebMvcTest @MockBean```
```java

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemBusinessServiceImpl itemBusinessServiceImpl;

    @BeforeEach
    void setup(){

    }

    @Test
    public void dummy_item_basic() throws Exception {

        String expected = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantitiy\":100}";
        // call GET "/dummy-item" application/json
        RequestBuilder request = MockMvcRequestBuilders
                .get("/dummy-item")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantitiy\":100}"))
                .andReturn();



    @Test
    public void itemFromBusinessService() throws Exception {

        String expected = "{\"id\":2,\"name\":\"Ball\",\"price\":10,\"quantitiy\":10}";

        when(itemBusinessServiceImpl.retrieveSampleItem()).thenReturn(new Item(2, "Ball", 10, 10 ));

        // call GET "/dummy-item" application/json
        RequestBuilder request = MockMvcRequestBuilders
                .get("/item-from-business-service")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json(expected))
                .andReturn();
    }



    @Test
    public void retreiveAllItems_basic() throws Exception {

        String expected = "[{\"id\":2,\"name\":\"Ball\",\"price\":10,\"quantitiy\":10}]";

        when(itemBusinessServiceImpl.retrieveAllItems()).thenReturn(Arrays.asList(new Item(2, "Ball", 10, 10 )));

        // call GET "/dummy-item" application/json
        RequestBuilder request = MockMvcRequestBuilders
                .get("/get-all-items-from-database")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json(expected))
                .andReturn();
    }
}


```

* (4) ``` @SpringBootTest @TestPropertySource```
```
Intergration Test

```
```java
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = {"classpath:test-configuration.properties"})
public class ItemControllerIT {

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private ItemRepository itemRepository;

    @Test
    public  void contextLoads() throws JSONException {
       String reponse = this.restTemplate.getForObject("/get-all-items-from-database", String.class);
        JSONAssert.assertEquals("[{id:1001},{id:1002},{id:1003}]", reponse, false);
    }
}

````

