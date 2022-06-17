import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import uk.practicalcoding.assembler.Assembler;
import uk.practicalcoding.assembler.it.AsmTestData;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HexFormat;

import static org.junit.Assert.assertEquals;

public class AssemblerIT
{
    @Test
    public void shouldConvertC64ChangeBorderASMtoMachineCode() throws Exception
    {
        final String json = Files.readString(
                Paths.get(getClass().getResource("c64-change-border.json" ).toURI() ) );

        final ObjectMapper objectMapper = new ObjectMapper();
        final AsmTestData testCase = objectMapper.readValue( json, AsmTestData.class );

        System.out.println( testCase );

        Assembler assembler = new Assembler();
        byte[] machineCodeBytes = assembler.assemble(testCase.getSourceCode());

        // convert to hex string for easy comparison
        final String machineCodeHexStr = HexFormat.of().formatHex( machineCodeBytes );

        assertEquals( testCase.getMachineCode(), machineCodeHexStr );
    }
}
