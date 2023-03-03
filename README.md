# prova_sicredi #
#######################
###      Notes      ###
#######################
1. Each test was created based on swagger documentation with rest-Assured test framework.
#######################
### Step Execution: ###
#######################
1. It is possible to execute each class separately or inside each Class is possible to execute each method.

###################
### Bugs Found: ###
###################
| Bug | Test                                                | Actual Return Code/Message                        | Expected Return Code/Message                                                                                                  | Notes                                                                                                                                         |
| 01  | RestrictionTest/validateCpfWithRestriction          | O CPF 97093236014 tem problema                    |"O CPF 97093236014 possui restrição"                                                                                           | This incorrect message is happen for all CPF in this data test                                                                                |
| 02  | SimulatorTest/insertInvalidSimulationsValues        | Status Code 201 when There is invalid Min Value   | Status Code 400 -> Swagger expected 404 but this is executed when NOT_FOUND a record                                          | Incorrect status code when we send invalid values during insertion simulation test.                                                           |
| 03  | SimulatorTest/insertInvalidSimulationsValues        | Status Code 201 when There is invalid Max Parcela | Status Code 400                                                                                                               | Incorrect status code when we send invalid values during insertion simulation test.                                                           |
| 04  | SimulatorTest/insertDuplicateSimulations            | Status Code 400 and "mensagem": "CPF duplicado"   | Status Code 409 and "mensagem": CPF já existente                                                                              | Delete added at the test only to allow new executions                                                                                         |
