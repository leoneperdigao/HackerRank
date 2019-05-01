package br.com.leoneperdigao.sockmerchant.poc;

import static br.com.leoneperdigao.sockmerchant.Solution.sockMerchant;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.leoneperdigao.sockmerchant.utils.FileUtils;


@RunWith(MockitoJUnitRunner.class)
public class AplicationTest {
	
	private static final String INPUT_0 = "src/test/resources/input/input00.txt";
	private static final String INPUT_08 = "src/test/resources/input/input08.txt";
	private static final String OUTPUT_0 = "src/test/resources/output/output00.txt";
	private static final String OUTPUT_08 = "src/test/resources/output/output08.txt";
	
	private static int EXPECTED_0;
	private static int EXPECTED_08;
	
	@Before
	public void setup() throws IOException {
		EXPECTED_0 = FileUtils.getEntrySize(OUTPUT_0);
		EXPECTED_08 = FileUtils.getEntrySize(OUTPUT_08);
	}

    @Test
    public void test00() throws IOException {

    	int entry = FileUtils.getEntrySize(INPUT_0);
    	int[] arr = FileUtils.getArray(entry, INPUT_0);
    	
    	assertEquals(EXPECTED_0, sockMerchant(entry, arr));
    }
    
    @Test
    public void test08() throws IOException {

    	int entry = FileUtils.getEntrySize(INPUT_08);
    	int[] arr = FileUtils.getArray(entry, INPUT_08);
    	
    	assertEquals(EXPECTED_08, sockMerchant(entry, arr));
    }

    
}
