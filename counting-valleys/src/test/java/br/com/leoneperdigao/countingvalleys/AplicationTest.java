package br.com.leoneperdigao.countingvalleys;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.leoneperdigao.countingvalleys.utils.FileUtils;


@RunWith(MockitoJUnitRunner.class)
public class AplicationTest {
	
	private static final String INPUT_0 = "src/test/resources/input/input00.txt";
	private static final String INPUT_01 = "src/test/resources/input/input01.txt";
	private static final String OUTPUT_0 = "src/test/resources/output/output00.txt";
	private static final String OUTPUT_01 = "src/test/resources/output/output01.txt";
	
	private static int EXPECTED_0;
	private static int EXPECTED_01;
	
	@Before
	public void setup() throws IOException {
		EXPECTED_0 = FileUtils.getEntrySize(OUTPUT_0);
		EXPECTED_01 = FileUtils.getEntrySize(OUTPUT_01);
	}

    @Test
    public void test00() throws IOException {

    	int entry = FileUtils.getEntrySize(INPUT_0);
    	String path = FileUtils.getPath(INPUT_0);
    	
    	assertEquals(EXPECTED_0, Solution.countingValleys(entry, path));
    }
    
    @Test
    public void test08() throws IOException {

    	int entry = FileUtils.getEntrySize(INPUT_01);
    	String path = FileUtils.getPath(INPUT_01);
    	
    	assertEquals(EXPECTED_01, Solution.countingValleys(entry, path));
    }

    
}
