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
### Reading submodels
Create a new object of the reader class for the used submodel standard.
By using the getter methods its possible to access the properties of the submodel.
```
ContactInformationReader1_0 reader = new ContactInformationReader1_0(contactInformationSubmodel);

List<ContactInformation> contactInformation = reader.getContactInformation();
```