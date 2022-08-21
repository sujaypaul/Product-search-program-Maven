# Product-search-program-Maven-
Implemention of a standalone product search program in Java that lists matching products for a user who is looking for T-shirts.<br><br>
We have 3 CSV files, each containing the T-shirts data for Nike, Puma and Adidas respectively.
We can add more data in existing files or can add more CSV files for another companies.
<br>
![image](https://user-images.githubusercontent.com/58883319/185786937-57f10ed3-da8d-48e1-9554-2de059e06b1c.png)<br>
![image](https://user-images.githubusercontent.com/58883319/185786989-219c31ec-8364-4d8d-9e5d-149d788f8555.png)<br>
### Input

Program accepts 4 input parameters

- Color
- Size
- Gender
- Output Preference 
 
“Gender” is a String which has two possible values like ‘M’ and ‘F’. M=Male and F=Female.<br>
“Output Preference” is a String which suggests whether the results should be sorted only by Price or by Rating or by both  Price and Rating.

- After getting the inputs, program searches for the T-shirts in all 3 csv files and list the results on standard output, sorted by Output Preference.
- Program is written considering that there could be more csv files and at runtime program should load the files. Please make use of Thread which will look for any new file at a particular configurable location after some configurable time and load the provided file
- If the suitable T-shirt is not present in any csv files, then program returns a user-friendly error
- Maven 3.x is used.
- CSVreader a 3rd party dependencies is used to read and parse CSV files.
- Includes an ant script to build a jar file for the same java program

### Output
Program displays the list of available T-shirts with details on console  for provided user inputs.

