#Zan Arts
#Milestone 1

  *Add product
  *View product
  *Update product
  *Delete product
  
## Table Definition: Product

| Column          | Type          | Attributes      | Description                           |
|-----------------|---------------|-----------------|---------------------------------------|
| id              | int           | AI, PK          | Unique identifier for the product     |
| productname     | varchar(255)  | NOT NULL        | Name of the product                   |
| artistname      | varchar(255)  | NOT NULL        | Name of the artist                    |
| price           | decimal(10,2) | NOT NULL        | Price of the product                  |
| productDescription | text        | NOT NULL        | Description of the product            |
| imageurl        | varchar(255)  | NOT NULL        | URL of the product's image            |
| category        | varchar(255)  | NOT NULL        | Category of the product               |
| width           | int           | NOT NULL        | Width of the product (in pixels)      |
| height          | int           | NOT NULL        | Height of the product (in pixels)     |
| updateTimestamp | timestamp     |                 | Timestamp of last update              |

