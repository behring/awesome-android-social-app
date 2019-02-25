package com.thoughtworks.awesomesocialapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import com.thoughtworks.awesomesocialapp.data.Repository;
import androidx.test.core.app.ApplicationProvider;
import static org.junit.Assert.*;

@RunWith(RobolectricTestRunner.class)
public class DataInjectionTest {

    @Test
    public void provideRepository() {
        Repository repository = DataInjection.provideRepository(ApplicationProvider.getApplicationContext());
        assertNotNull(repository);
        assertNotNull(repository.getApi());
        assertNotNull(repository.getDatabase());
    }
}