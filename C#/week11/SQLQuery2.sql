/*******************************************************************************/
/*																			   */
/*	Kroenke and Auer - Database Processing (12th Edition) Chapter 02		   */
/*																			   */
/*	Cape Codd Outdoor Sports - Insert Data									   */
/*																			   */
/*	These are the Microsoft SQL Server 2008 / 2008 R2 SQL code solutions	   */
/*																			   */
/*******************************************************************************/
/********************************************************************************/
/*																				*/
/*	Kroenke and Auer - Database Processing (12th Edition) Chapter 02			*/
/*																				*/
/*	Cape Codd Outdoor Sports - Create Tables									*/
/*																				*/
/*	These are the Microsoft SQL Server 2008 / 2008 R2 SQL code solutions		*/
/*																				*/
/********************************************************************************/

CREATE TABLE RETAIL_ORDER (
	OrderNumber     Integer 	NOT NULL,
	StoreNumber     Integer 	NULL,
	StoreZip        Char(9) 	NULL,
	OrderMonth    	Char(12) 	NOT NULL,
	OrderYear     	Integer 	NOT NULL,
	OrderTotal   	Money		NULL,
	CONSTRAINT 		RETAIL_ORDER_PK PRIMARY KEY (OrderNumber)
	);

CREATE TABLE SKU_DATA (
	SKU   			Integer 	NOT NULL,
	SKU_Description Char(35) 	NOT NULL,
	Department  	Char(30)  	NOT NULL,
	Buyer  			Char(35)  	NULL,
	CONSTRAINT 		SKU_DATA_PK 	PRIMARY KEY (SKU)
	);

CREATE TABLE ORDER_ITEM (
	OrderNumber  	Integer  	NOT NULL,
	SKU  			Integer 	NOT NULL,
	Quantity  		Integer 	NOT NULL,
	Price  			Money	 	NOT NULL,
	ExtendedPrice  	Money		NOT NULL,
	CONSTRAINT 		ORDER_ITEM_PK 		PRIMARY KEY (SKU, OrderNumber),
	CONSTRAINT 		SKU_Relationship 	FOREIGN KEY (SKU)
							REFERENCES 	SKU_DATA (SKU),
	CONSTRAINT 		RETAIL_ORDER_Relationship 	FOREIGN KEY (OrderNumber)
							REFERENCES 	RETAIL_ORDER (OrderNumber)
	);
	
CREATE TABLE WAREHOUSE (
	WarehouseID		Integer		NOT NULL,
	WarehouseCity	Char(30)  	NOT NULL,
	WarehouseState	Char(2)		NOT NULL,
	Manager			Char(35)	NULL,
	SquareFeet		Integer		NULL,
	CONSTRAINT 		WAREHOUSE_PK 	PRIMARY KEY (WarehouseID)
	);
	
CREATE TABLE INVENTORY (
	WarehouseID  	Integer  	NOT NULL,
	SKU   			Integer 	NOT NULL,
	SKU_Description Char(35) 	NOT NULL,
	QuantityOnHand 	Integer  	NULL,
	QuantityOnOrder	Integer  	NULL,
	CONSTRAINT 		INVENTORY_PK 	PRIMARY KEY (WarehouseID, SKU),
	CONSTRAINT 		SKU_DATA_Relationship 	FOREIGN KEY (SKU)
							REFERENCES 	SKU_DATA (SKU),
	CONSTRAINT 		WAREHOUSE_Relationship 	FOREIGN KEY (WarehouseID)
							REFERENCES 	WAREHOUSE (WarehouseID)
	);


-- RETAIL_ORDER Data

INSERT INTO RETAIL_ORDER VALUES (
	1000, 10, '98110', 'December', 2010, 445);
INSERT INTO RETAIL_ORDER VALUES (
	2000, 20, '02335', 'December', 2010, 310);
INSERT INTO RETAIL_ORDER VALUES (
	3000, 10, '98110', 'January', 2011, 480);

-- SKU_DATA Data

INSERT INTO SKU_DATA VALUES (
	100100, 'Std. Scuba Tank, Yellow', 'Water Sports', 'Pete Hansen');
INSERT INTO SKU_DATA VALUES (
	100200, 'Std. Scuba Tank, Magenta', 'Water Sports', 'Pete Hansen');
INSERT INTO SKU_DATA VALUES (
	101100, 'Dive Mask, Small Clear', 'Water Sports', 'Nancy Meyers');
INSERT INTO SKU_DATA VALUES (
	101200, 'Dive Mask, Med Clear', 'Water Sports', 'Nancy Meyers');
INSERT INTO SKU_DATA VALUES (
	201000, 'Half-dome Tent', 'Camping', 'Cindy Lo');		
INSERT INTO SKU_DATA VALUES (
	202000, 'Half-dome Tent Vestibule', 'Camping', 'Cindy Lo');
INSERT INTO SKU_DATA VALUES (
	301000, 'Light Fly Climbing Harness', 'Climbing', 'Jerry Martin');		
INSERT INTO SKU_DATA VALUES (
	302000, 'Locking Carabiner, Oval', 'Climbing', 'Jerry Martin');	

-- ORDER_ITEM Data

INSERT INTO ORDER_ITEM VALUES (
	1000, 201000, 1, 300, 300);
INSERT INTO ORDER_ITEM VALUES (
	1000, 202000, 1, 130, 130);
INSERT INTO ORDER_ITEM VALUES (
	2000, 101100, 4, 50, 200);
INSERT INTO ORDER_ITEM VALUES (
	2000, 101200, 2, 50, 100);
INSERT INTO ORDER_ITEM VALUES (
	3000, 100200, 1, 300, 300);
INSERT INTO ORDER_ITEM VALUES (
	3000, 101100, 2, 50, 100);
INSERT INTO ORDER_ITEM VALUES (
	3000, 101200, 1, 50, 50);

-- WAREHOUSE Data
						
INSERT INTO WAREHOUSE VALUES (
	100, 'Atlanta', 'GA','Dave Jones', 125000);
INSERT INTO WAREHOUSE VALUES (
	200, 'Chicago', 'IL', 'Lucille Smith', 100000);
INSERT INTO WAREHOUSE VALUES (
	300, 'Bangor', 'ME', 'Bart Evans', 150000);
INSERT INTO WAREHOUSE VALUES (
	400, 'Seattle', 'WA','Dale Rogers', 130000);
INSERT INTO WAREHOUSE VALUES (
	500, 'San Francisco', 'CA','Grace Jefferson', 200000);
		
	
-- INVENTORY Data

INSERT INTO INVENTORY VALUES (
	100, 100100, 'Std. Scuba Tank, Yellow', 250, 0);
INSERT INTO INVENTORY VALUES (
	200, 100100, 'Std. Scuba Tank, Yellow', 100, 50);
INSERT INTO INVENTORY VALUES (
	300, 100100, 'Std. Scuba Tank, Yellow', 100, 0);
INSERT INTO INVENTORY VALUES (
	400, 100100, 'Std. Scuba Tank, Yellow', 200, 0);
INSERT INTO INVENTORY VALUES (
	100, 100200, 'Std. Scuba Tank, Magenta', 200, 30);
INSERT INTO INVENTORY VALUES (
	200, 100200, 'Std. Scuba Tank, Magenta', 75, 75);
INSERT INTO INVENTORY VALUES (
	300, 100200, 'Std. Scuba Tank, Magenta', 100, 100);
INSERT INTO INVENTORY VALUES (
	400, 100200, 'Std. Scuba Tank, Magenta', 250, 0);
INSERT INTO INVENTORY VALUES (
	100, 101100, 'Dive Mask, Small Clear', 0, 500);
INSERT INTO INVENTORY VALUES (
	200, 101100, 'Dive Mask, Small Clear', 0, 500);
INSERT INTO INVENTORY VALUES (
	300, 101100, 'Dive Mask, Small Clear', 300, 200);
INSERT INTO INVENTORY VALUES (
	400, 101100, 'Dive Mask, Small Clear', 450, 0);
INSERT INTO INVENTORY VALUES (
	100, 101200, 'Dive Mask, Med Clear', 100, 500);
INSERT INTO INVENTORY VALUES (
	200, 101200, 'Dive Mask, Med Clear', 50, 500);
INSERT INTO INVENTORY VALUES (
	300, 101200, 'Dive Mask, Med Clear', 475, 0);
INSERT INTO INVENTORY VALUES (
	400, 101200, 'Dive Mask, Med Clear', 250, 250);
INSERT INTO INVENTORY VALUES (
	100, 201000, 'Half-dome Tent', 2, 100);
INSERT INTO INVENTORY VALUES (
	200, 201000, 'Half-dome Tent', 10, 250);
INSERT INTO INVENTORY VALUES (
	300, 201000, 'Half-dome Tent', 250, 0);
INSERT INTO INVENTORY VALUES (
	400, 201000, 'Half-dome Tent', 0, 250);
INSERT INTO INVENTORY VALUES (
	100, 202000, 'Half-dome Tent Vestibule', 10, 250);
INSERT INTO INVENTORY VALUES (
	200, 202000, 'Half-dome Tent Vestibule', 1, 250);
INSERT INTO INVENTORY VALUES (
	300, 202000, 'Half-dome Tent Vestibule', 100, 0);
INSERT INTO INVENTORY VALUES (
	400, 202000, 'Half-dome Tent Vestibule', 0, 200);
INSERT INTO INVENTORY VALUES (
	100, 301000, 'Light Fly Climbing Harness', 300, 250);
INSERT INTO INVENTORY VALUES (
	200, 301000, 'Light Fly Climbing Harness', 250, 250);
INSERT INTO INVENTORY VALUES (
	300, 301000, 'Light Fly Climbing Harness', 0, 250);
INSERT INTO INVENTORY VALUES (
	400, 301000, 'Light Fly Climbing Harness', 0, 250);
INSERT INTO INVENTORY VALUES (
	100, 302000, 'Locking Carabiner, Oval', 1000, 0);
INSERT INTO INVENTORY VALUES (
	200, 302000, 'Locking Carabiner, Oval', 1250, 0);
INSERT INTO INVENTORY VALUES (
	300, 302000, 'Locking Carabiner, Oval', 500, 500);
INSERT INTO INVENTORY VALUES (
	400, 302000, 'Locking Carabiner, Oval', 0, 1000);

/*******************************************************************************/
