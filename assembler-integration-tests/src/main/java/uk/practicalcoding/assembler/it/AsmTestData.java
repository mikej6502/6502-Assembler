package uk.practicalcoding.assembler.it;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AsmTestData
{
    private final String sourceCode;
    private final String machineCode;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public AsmTestData( @JsonProperty( "sourceCode" ) final String sourceCode, @JsonProperty( "machineCode" ) final String machineCode )
    {
        this.sourceCode = sourceCode;
        this.machineCode = machineCode;
    }

    public String getSourceCode()
    {
        return sourceCode;
    }

    public String getMachineCode()
    {
        return machineCode;
    }

    @Override
    public String toString()
    {
        return "AsmTestData{" +
                "sourceCode='" + sourceCode + '\'' +
                ", machineCode='" + machineCode + '\'' +
                '}';
    }
}
