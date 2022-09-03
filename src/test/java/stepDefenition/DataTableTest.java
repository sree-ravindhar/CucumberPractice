package stepDefenition;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

import java.util.List;

public class DataTableTest {
    @Given("SetUp enter URL")
    public void set_up_enter_url() {
        System.out.println("Launch");
    }
    @When("Try data Table")
    public void try_data_table(DataTable dataTable) {
        String cell = dataTable.cell(0, 0);
        System.out.println(cell);
        String cell1 = dataTable.cell(0, 1);
        System.out.println(cell1);
        String cell2 = dataTable.cell(1, 0);
        System.out.println(cell2);
        String cell3 = dataTable.cell(1,1);
        System.out.println(cell3);


    }
    @Then("Verify the user is able to get the above data")
    public void verify_the_user_is_able_to_get_the_above_data() {
        System.out.println("Done");
    }
}
