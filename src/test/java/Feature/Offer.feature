Feature: Verifying Product in OfferPage 




@offer 
Scenario Outline: Verify product in offerpage 

	Given User lands in Green Cart Home Page 
	When User click Top deal link 
	And User search the product with "<sheetName> " and <RowNumber> in deals 
	Then User check if the product matches with landingpage
	
		Examples: 
		| SheetName  | RowNumber |
		| product	 |   0       |
		
		
		
