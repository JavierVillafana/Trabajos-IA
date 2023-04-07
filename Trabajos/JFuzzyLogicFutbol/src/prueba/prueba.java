package prueba;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import net.sourceforge.jFuzzyLogic.*;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;


public class prueba{
    public static void main(String []args)throws Exception{
        //Cargar desde el archivo 'FCL'
        String fileName = "src/futbol.fcl";
        FIS fis =FIS.load(fileName, true);
        if (fis == null) { // Error while loading?
			System.err.println("Can't load file: '" + fileName + "'");
			return;
		}
        


           // Show ruleset
    	FunctionBlock functionBlock = fis.getFunctionBlock(null);
		//FunctionBlock functionBlock = fis.getFunctionBlock(null);
		//JFuzzyChart.get().chart(functionBlock);
		
		

		// Set inputs
		functionBlock.setVariable("posicion", 0.2);
		functionBlock.setVariable("falta", 1);
        functionBlock.setVariable("area",0.75);

		// Evaluate 
		functionBlock.evaluate();

		// Show output variable's chart
		//Variable result = functionBlock.getVariable("result");
		//JFuzzyChart.get().chart(result, result.getDefuzzifier(), true);
		//Gpr.debug("poor[service]: " + functionBlock.getVariable("service").getMembership("poor"));

		// Print ruleSet
		System.out.println(functionBlock);
		System.out.println("Result:" + functionBlock.getVariable("result").getValue());
  }
}
