Annotations
-----

* (0) ``` @Test  ```

* (1) ``` @InjectMocks @Mock @RunWith```

```
Let's now migrate a test that uses a JUnit4-based runner to JUnit5.

We're going to use a Spring test as an example:

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SpringTestConfiguration.class })
public class GreetingsSpringTest {
    // ...
}
If we want to migrate this test to JUnit5 we need to replace the @RunWith annotation with the new @ExtendWith:

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { SpringTestConfiguration.class })
public class GreetingsSpringTest {
    // ...
}
The SpringExtension class is provided by Spring 5 and integrates the Spring TestContext Framework into JUnit 5. The @ExtendWith annotation accepts any class that implements the Extension interface.
```
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


* (2) ``` @MockBean @Mock```

* (2) ``` @DataJpaTest```


* (3) ``` @WebMvcTest```

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

