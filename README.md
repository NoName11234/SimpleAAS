# SimpleAAS library
Java library for simple usage of different submodel standards of asset administration shells.

## Supported submodel standards
| Submodel Name | Version | Reading | Writing |
|----|----|----|---------|
| Contact Information | 1.0 | Yes | Yes     |
| Digital Nameplate | 2.0 | Yes | No      |
| Digital Nameplate | 3.0 | Yes | Yes     |

## Usage
### Reading
Create a new object of the reader class for the submodel standard with the submodel object.
By using the getter methods its possible to access the properties of the submodel and collect data objects with the data
of the submodel mapped on.

The following code example shows the usage of the reader class for the submodel standard contact information in version 1.0.
```
ContactInformationReader1_0 reader = new ContactInformationReader1_0(contactInformationSubmodel);

List<ContactInformation> contactInformation = reader.getContactInformation();
```
### Creating
Create a new object of the builder class for the contact information standard.
The constructor takes a submodel as a template.
This template can be downloaded from the IDTA website.
The values can be set by using the setter methods of the builder class.
Data objects are used for combining data according to the structure of the submodel standard.

The following code example shows the usage fo the builder class for the submodel standard contact information in version 1.0.
```
ContactInformationBuilder1_0 builder = new ContactInformationBuilder1_0(templateSubmodel);
ContactInformation contactInformation = new ContactInformation("ExampleContact");

contactInformation.setFirstName("NameOfContactPerson");
//set other values

builder.addContactInformation(contactInformation);

Submodel contactInformation = builder.createSubmodel();
```
