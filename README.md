# SimpleAAS library
Java library for simple usage of different submodel standards of asset administration shells.

## Supported submodel standards
| Submodel Name | Version | Reading | Writing | Testing |
|----|----|----|---------|----|
| Contact Information | 1.0 | Yes | Yes | No |

## Planned features
- Contact Information 1.0: conformity testing
- Digital Nameplate 2.0: reading, writing, conformity testing
- Digital Nameplate 3.0: reading, writing, conformity testing

## Usage
### Contact Information
#### Reading
Create a new object of the reader class for the contact information standard with the submodel object.
By using the getter methods its possible to access the properties of the submodel and collect data objects with the data
of the submodel mapped on.
```
ContactInformationReader1_0 reader = new ContactInformationReader1_0(contactInformationSubmodel);

List<ContactInformation> contactInformation = reader.getContactInformation();
```
#### Creating
Create a new object of the builder class for the contact information standard.
The constructor takes a submodel as a template.
This template can be downloaded from the IDTA website.
The values can be set by using the setter methods of the builder class.
Data objects are used for combining data according to the structure of the submodel standard.
```
ContactInformationBuilder1_0 builder = new ContactInformationBuilder1_0(templateSubmodel);
ContactInformation contactInformation = new ContactInformation("ExampleContact");

contactInformation.setFirstName("NameOfContactPerson");
//set other values

builder.addContactInformation(contactInformation);

Submodel contactInformation = builder.createSubmodel();
```