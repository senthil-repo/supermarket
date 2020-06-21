Please refer the following packages/folders to understand more on the design approach of this software.

1) kata.supermarket.item
2) kata.supermarket.product
3) kata.supermarket.discount

Design details: 

Item & AbstractItem:	
	It gives an abstract definition of the item, the product that this item ‘relates to’ and discount entities. 
	ItemByUnit and ItemByWeight are the implementation classes.

Product:	
	It gives an abstract view of a product. UnitProduct & WeighedProduct are the implementation classes. 
	
Discount:	
	DiscountRule gives the abstract definition of the rules/discounts that are applied on the items.
	
Pricing Model:	
 	I understand, that the fully functional supermarket system needs consideration on various aspects (like price, type, quantity limit, multiple offers, etc..) of discount and offers. For example, a discount can be applied based on the following additional information:	
 	1) Type of product - E.g cloth, Can of baked beans, Bread, ToothPaste.
 		Here all are sold by ‘unit’, but still the category of these products are different and hence the price can be different.A discount scheme can be applied to any of these categories, but 2 items from the above list may not be combined, as the prices may be different.  	
		
 	2) Multiple offers/promotions can be applied to a same product.    
	
 	3) etc….
 	
 
Based on the current information and considering the time given, I have taken a simplest approach on modelling the pricing component, as below:	
	- A discount scheme should have the list of products that the discount is applicable for. So while applying the rule, 
	it compares the item from the basket against the list, and consider only them for processing.
	
Based on the above pricing model, I have implemented only one rule - BuyOneGetOneFree in ‘Discount_BuyOneGetOneSingle.java’. Explanation below:	
	
	- If the discount not applied already & the item is present in the list of eligible products, then consider those for processing.	
	
	- Offer will be applied only up-to the maximum number of even quantities E.g - for a list of 5 items, only 4 can be considered for discount. The remaining one has to be fully paid    
	
	- Update the price of the respective sub-set of items as ‘0’ and set a flag on the eligible list to indicate that the offer is applied on these items.

Future enhancements:	
	- The basket will be supplied to all other Rules and respective/eligible discounts will be applied	
	
	- By adding additional entities of a product, we can group the items based on price/type, so that discounts can be applied accordingly.	
	- We can introduce another layer called ‘DiscounType(s)’ (BUY1GET1_SINGLE, BUY1GET1_MIX, BUYKGFORHALFPRICE_SINGLE, etc…) 
	to give more flexibility on handling the discounts, multiple discounts, etc.


Testing:	
	
	- I have done unit testing to test BuyOneGetOneFree scheme 
	
	- Please refer kata.supermarket.discount.scheme.Discount_BuyOneGetOneSingleTest.java	
	
	- I have done Integration testing on the Basket level, to show the price before and after discounts along with the discount amount that we save. Please refer 'BasketIntegrationTest.java.
	
	- I have commented out existing test classes for the time being.
