## Files created

-Following files were created in the application:
Controller: ExtractDataController.java
Model: InputData.java (to map the input to ReuestBody), OutputData.java(to map the extracted values), ExtractedResponse.java(to map the actual output)
Service: ExtractDataService.java (Interface to declare the method), ExtractDataServiceImpl.java (Implementation class, to implement the defined method in interface)

## Unit test

-Unit test:ExtractDataControllerTest.java - I have created a unit test, using MockMvc and tested a sample in it.

## Output

-The sample response mentioned, is in the below format:
{
 "id": "04a63473-b370-4026-9af8-dbc576cebd87"
 [
 {
 "extractedText": "24"
 "extractedValue": 24
 "startPosition": 91
 "endPosition": 93
 }
 ]
}

I have created a model, to map the output as shown in the sample above:
However, I am getting the name of the list in the output
{
    "id": "04a63473-b370-4026-9af8-dbc576cebd87",
    "outputDataList": [
        {
            "extractedText": "24",
            "extractedValue": 24,
            "startPosition": 91,
            "endPosition": 93
        }
    ]
}
