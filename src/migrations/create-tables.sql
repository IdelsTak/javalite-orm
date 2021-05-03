/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  mwangi
 * Created: May 3, 2021
 */

CREATE TABLE EMPLOYEES (
    ID BIGINT DEFAULT AUTOINCREMENT: start 1 increment 1  NOT NULL GENERATED ALWAYS AS IDENTITY, 
    FIRSTNAME VARCHAR(50) NOT NULL, 
    LASTNAME VARCHAR(50), 
    CREATEDON TIMESTAMP DEFAULT CURRENT_TIMESTAMP  NOT NULL, 
    MODIFIEDON TIMESTAMP, 
    PRIMARY KEY (ID)
);
