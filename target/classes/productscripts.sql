-- Use the database
USE santhanam_mariappan_corejava_project;

-- Create the 'products' table
CREATE TABLE `products` (
  `id` int NOT NULL AUTO_INCREMENT, -- Primary key, auto-incrementing integer
  `productname` varchar(255) DEFAULT NULL, -- Product name (max 255 characters)
  `artistname` varchar(255) DEFAULT NULL, -- Artist name (max 255 characters)
  `price` decimal(10,2) DEFAULT NULL, -- Price with 10 total digits and 2 decimal places
  `productDescription` text, -- Product description (text)
  `imageurl` varchar(255) DEFAULT NULL, -- Image URL (max 255 characters)
  `category` varchar(255) DEFAULT NULL, -- Category (max 255 characters)
  `width` int DEFAULT NULL, -- Width dimension
  `height` int DEFAULT NULL, -- Height dimension
  `updateTimestamp` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, -- Update timestamp
  PRIMARY KEY (`id`) -- Primary key constraint on 'id' column
);

-- Select all records from the 'products' table
SELECT * FROM products;
