import pandas

excelData = pandas.read_excel('Activity19_Output.xlsx')

print("Data present n excel sheet:")
print(excelData)

print("")
print("Total number of rows and columns in excel:", excelData.shape)

print("")
print("Email ids:")
print(excelData['Email'])

print("")
print("Sorted data on FirstName:")
print(excelData.sort_values('FirstName'))
