# number-converter-backend

This application exposes and API that allows the conversion from one numeric type to another. example : Decimal > Roman Or Binary > Roman.

The above-mentioned conversions are the only supported ones at the moment. but this application was built in a generic way to support more types in the future without the need to touch excisting logic as follows: 

We are using service which acts as a template with a factory pattern that always convert the "From Type" to Base (Decimal) then from Decimal to the desired "To Type".
This way we achieved maximum flexibility and more reusable code when we start supporting more types than using concrete implementation for each combination (BinaryToRoman, DecimalToRoman...) because later when we start supporting (Roman to English, Decimal To English, Hex to English) it will reuse the DecimalToEnglish in all 3 cases. 

Testing the application is possible by: 
1- Direct API  calls: check OpenAPI documentation http://localhost:8080/swagger-ui/index.html
2- Angular application

Note: To support converting Roman to English letters in the future we should implement 2 classes: 
1- Convert roman to Decimal (This will allow us to convert roman to other type in the future like Hex, binary...)
2- Convert decimal to English (This will be generic one which will be reused by more classes).




