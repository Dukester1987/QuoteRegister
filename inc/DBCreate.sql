 i -- phpMyAdmin SQL Dump
-- version 4.3.8
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Sep 22, 2016 at 06:29 PM
-- Server version: 5.6.29-76.2
-- PHP Version: 5.4.31


--
-- Database: `sopsioco_DAR`
--

-- --------------------------------------------------------

--
-- Table structure for table `AFAllocation`
--

CREATE TABLE IF NOT EXISTS `AFAllocation` (
  `ID` int(11) NOT NULL,
  `SiteID` int(11) NOT NULL,
  `VehicleID` varchar(20)  NOT NULL,
  `Description` varchar(80)  NOT NULL,
  `StartDate` date NOT NULL,
  `EndDate` date NOT NULL
);

--
-- Table structure for table `QR_TruckGroups`
--

CREATE TABLE IF NOT EXISTS `QR_TruckGroups` (
  `ID` int(11) NOT NULL,
  `GroupName` varchar(120) NOT NULL
);

--
-- Table structure for table `TruckGroups`
--

CREATE TABLE IF NOT EXISTS `TruckGroups` (
  `ID` int(11) NOT NULL,
  `GroupName` varchar(120) NOT NULL,
  `GroupBudget` decimal(10,2) NOT NULL
);

--
-- Table structure for table `StockAdjustments`
--

CREATE TABLE IF NOT EXISTS `StockAdjustments` (
  `ID` int(11) NOT NULL,
  `SiteID` int(11) NOT NULL,
  `ProductID` int(11) NOT NULL,
  `Qty` decimal(10,2) NOT NULL,
  `Comment` varchar(180) NOT NULL
);
-- --------------------------------------------------------

--
-- Table structure for table `Sales`
--

CREATE TABLE IF NOT EXISTS `Sales` (
  `ID` int(11) NOT NULL,
  `SiteID` int(11) NOT NULL,
  `ProductID` int(11) NOT NULL,
  `Direction` varchar(10) NOT NULL,
  `Amount` decimal(10,2) NOT NULL,
  `PriceIncGST` decimal(10,3) NOT NULL,
  `PriceExGST` decimal(10,3) NOT NULL,
  `DateFor` date NOT NULL,
  `ApprovalID` INT NULL
);
-- --------------------------------------------------------

--
-- Table structure for table `AFFuel`
--

CREATE TABLE IF NOT EXISTS `AFFuel` (
  `ID` int(11) NOT NULL,
  `AFAllocationID` int(11) NOT NULL,
  `Amount` double(18) NOT NULL,
  `DateFor` date NOT NULL
);

-- --------------------------------------------------------

--
-- Table structure for table `ChangeLog`
--

CREATE TABLE IF NOT EXISTS `ChangeLog` (
  `ID` int(11) NOT NULL,
  `AffectedTable` varchar(80)  NOT NULL,
  `RowID` varchar(36)  NOT NULL,
  `Operation` varchar(10)  NOT NULL,
  `NewValue` text  NOT NULL,
  `LoginID` int(4) NOT NULL,
  `Time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `UID` varchar(36)  NOT NULL,
  `DateFor` DATE NULL,
  `SiteID` INT NULL  
);

--
-- Table structure for table `inputValidation`
--

CREATE TABLE IF NOT EXISTS `inputValidation` (
  `ID` int(11) NOT NULL,
  `LoginID` int(11) NOT NULL,
  `Comment` text NOT NULL
);
-- --------------------------------------------------------

--
-- Table structure for table `EPA`
--

CREATE TABLE IF NOT EXISTS `EPA` (
  `ID` int(11) NOT NULL,
  `Rate` double NOT NULL,
  `DateFor` date NOT NULL
);

-- --------------------------------------------------------

--
-- Table structure for table `LaborAllocation`
--

CREATE TABLE IF NOT EXISTS `LaborAllocation` (
  `ID` int(11) NOT NULL,
  `LaborID` int(11) NOT NULL,
  `SiteID` int(11) NOT NULL,
  `StartDate` date NOT NULL,
  `EndDate` date DEFAULT NULL
) ;


-- --------------------------------------------------------

--
-- Table structure for table `LaborFunctions`
--

CREATE TABLE IF NOT EXISTS `LaborFunctions` (
  `ID` int(11) NOT NULL,
  `Function` varchar(80)  NOT NULL
)   ;

--
-- Dumping data for table `LaborFunctions`
--



-- --------------------------------------------------------

--
-- Table structure for table `LaborList`
--

CREATE TABLE IF NOT EXISTS `LaborList` (
  `ID` int(11) NOT NULL,
  `LaborName` varchar(80)  NOT NULL,
  `LaborFunction` int(11) NOT NULL,
  `LaborRate` double NOT NULL
) ;


-- --------------------------------------------------------

--
-- Table structure for table `LaborStatus`
--

CREATE TABLE IF NOT EXISTS `LaborStatus` (
  `ID` int(11) NOT NULL,
  `Status` varchar(50)  NOT NULL
);

--
-- Dumping data for table `LaborStatus`
--



-- --------------------------------------------------------

--
-- Table structure for table `LaborUtilization`
--

CREATE TABLE IF NOT EXISTS `LaborUtilization` (
  `ID` int(11) NOT NULL,
  `LaborAllocationID` int(11) NOT NULL,
  `PlantID` varchar(5)  NOT NULL,
  `Hours` decimal(10,2) NOT NULL,
  `Status` int(5) NOT NULL,
  `Notes` varchar(300)  NOT NULL,
  `DateFor` date NOT NULL,
  `ApprovalID` INT NULL
);

-- --------------------------------------------------------

--
-- Table structure for table `Login`
--

CREATE TABLE IF NOT EXISTS `Login` (
  `ID` int(11) NOT NULL,
  `LoginName` varchar(80) NOT NULL,
  `Password` varchar(32) NOT NULL,
  `Rights` varchar(500) NOT NULL,
  `Status` int(11) NOT NULL,
  `LastUpload` timestamp NULL DEFAULT NULL,
  `LastDownload` timestamp NULL DEFAULT NULL,
  `LastLogin` timestamp NULL DEFAULT NULL,
  `LastActivity` timestamp NULL DEFAULT NULL,
  `Name` varchar(32)  DEFAULT NULL,
  `LastName` varchar(32)  DEFAULT NULL
);



-- --------------------------------------------------------

--
-- Table structure for table `PlantAllocation`
--

CREATE TABLE IF NOT EXISTS `PlantAllocation` (
  `ID` int(11) NOT NULL,
  `PlantID` varchar(20)  NOT NULL,
  `SiteID` int(11) NOT NULL,
  `StartDate` date NOT NULL,
  `EndDate` date DEFAULT NULL
);


-- --------------------------------------------------------

--
-- Table structure for table `PlantList`
--

CREATE TABLE IF NOT EXISTS `PlantList` (
  `ID` varchar(20)  NOT NULL,
  `PlantDesc` varchar(80)  NOT NULL,
  `Rate` decimal(10,2) NOT NULL,
  `UnitOfMeasurement` varchar(5)  NOT NULL
);

--
-- Dumping data for table `PlantList`
--



-- --------------------------------------------------------

--
-- Table structure for table `PlantUtilization`
--

CREATE TABLE IF NOT EXISTS `PlantUtilization` (
  `ID` int(11) NOT NULL,
  `PlantAllocationID` int(11) NOT NULL,
  `StartHours` int(11) NOT NULL,
  `EndHours` int(11) NOT NULL,
  `DateFor` date NOT NULL,
  `Fuel` decimal(10,2) NOT NULL,
  `Notes` varchar(300)  NOT NULL,
  `ApprovalID` INT NULL
);


--
-- Table structure for table `ProductAllocation`
--

CREATE TABLE IF NOT EXISTS `ProductAllocation` (
  `ID` int(11) NOT NULL,
  `ProductID` int(11) NOT NULL,
  `SiteID` int(11) NOT NULL,
  `StartDate` date NOT NULL,
  `EndDate` date DEFAULT NULL
);

--
-- Dumping data for table `ProductAllocation`
--


-- --------------------------------------------------------

--
-- Table structure for table `ProductGroups`
--

CREATE TABLE IF NOT EXISTS `ProductGroups` (
  `ID` int(11) NOT NULL,
  `GroupName` varchar(80)  NOT NULL
);


-- --------------------------------------------------------

--
-- Table structure for table `ProductUtilization`
--

CREATE TABLE IF NOT EXISTS `ProductUtilization` (
  `ID` int(11) NOT NULL,
  `ProductAllocationID` int(11) NOT NULL,
  `Qty` decimal(10,2) NOT NULL,
  `Notes` varchar(300)  NOT NULL,
  `TransactionType` int(11) NOT NULL,
  `DateFor` date NOT NULL,
  `ApprovalID` INT NULL
);


-- --------------------------------------------------------

--
-- Table structure for table `Products`
--

CREATE TABLE IF NOT EXISTS `Products` (
  `ID` int(11) NOT NULL,
  `ProductName` varchar(80)  NOT NULL,
  `ProductVal` decimal(10,0) NOT NULL,
  `Type` int(2) NOT NULL,
  `EPA` int(11) NOT NULL,
  `GroupID` int(11) NOT NULL,
  `UOM` varchar(2)  NOT NULL,
  `AWS_CODE` varchar(150) NULL
);

--
-- Dumping data for table `Products`
--



-- --------------------------------------------------------

--
-- Table structure for table `Recipe`
--

CREATE TABLE IF NOT EXISTS `Recipe` (
  `ID` int(11) NOT NULL,
  `ProductAllocationID` int(11) NOT NULL,
  `SiteID` int(11) NOT NULL,
  `RecName` varchar(80)  NOT NULL,
  `status` tinyint(1) NOT NULL
)   ;


-- --------------------------------------------------------

--
-- Table structure for table `RecipeRel`
--

CREATE TABLE IF NOT EXISTS `RecipeRel` (
  `ID` int(11) NOT NULL,
  `RecID` int(11) NOT NULL,
  `ProductAllocationID` int(11) NOT NULL,
  `Used` double NOT NULL
)   ;


-- --------------------------------------------------------

--
-- Table structure for table `SiteList`
--

CREATE TABLE IF NOT EXISTS `SiteList` (
  `ID` int(11) NOT NULL,
  `SiteName` varchar(40) NOT NULL,
  `SiteDesc` varchar(80) NOT NULL,
  `AWS_ConnectionString` varchar(200)  DEFAULT NULL,
  `AWS_Login` varchar(80)  DEFAULT NULL,
  `AWS_Password` varchar(80)  DEFAULT NULL
);

--
-- Dumping data for table `SiteList`
--



-- --------------------------------------------------------

--
-- Table structure for table `SiteNotes`
--

CREATE TABLE IF NOT EXISTS `SiteNotes` (
  `ID` int(11) NOT NULL,
  `SiteID` int(11) NOT NULL,
  `Notes` text  NOT NULL,
  `DateFor` date NOT NULL
);

-- --------------------------------------------------------

--
-- Table structure for table `TransactionTypes`
--

CREATE TABLE IF NOT EXISTS `TransactionTypes` (
  `ID` int(11) NOT NULL,
  `Description` varchar(80)  NOT NULL
)   ;

--
-- Dumping data for table `TransactionTypes`
--


-- --------------------------------------------------------

--
-- Table structure for table `UpdateLog`
--

CREATE TABLE IF NOT EXISTS `UpdateLog` (
  `ID` int(11) NOT NULL,
  `Start` timestamp NULL DEFAULT NULL,
  `End` timestamp NULL DEFAULT NULL,
  `type` int(1) NOT NULL
);

-- --------------------------------------------------------

--
-- Table structure for table `QR_Clients`
--

CREATE TABLE IF NOT EXISTS `QR_Clients` (
  `ID` int(11) NOT NULL,
  `GlobeID` varchar(100) NOT NULL,
  `ClientName` varchar(100) NOT NULL
);

-- --------------------------------------------------------

--
-- Table structure for table `QR_Contacts`
--

CREATE TABLE IF NOT EXISTS `QR_Contacts` (
  `ID` int(11) NOT NULL,
  `ClientID` int(11) NOT NULL,
  `Name` varchar(100) NOT NULL,
  `LastName` varchar(100)  NOT NULL,
  `email` varchar(200)  NOT NULL,
  `phone` varchar(32)  NOT NULL
);

-- --------------------------------------------------------

--
-- Table structure for table `QR_JobProducts`
--

CREATE TABLE IF NOT EXISTS `QR_JobProducts` (
  `ID` varchar(36)  NOT NULL,
  `JobID` int(11) NOT NULL,
  `suffix` varchar(10) NOT NULL DEFAULT '',
  `ProductID` Varchar(130) NOT NULL,
  `Notes` text  NOT NULL,
  `Volume` decimal(10,2) NOT NULL,
  `Ongoing` boolean NOT NULL DEFAULT FALSE,
  `Direction` boolean DEFAULT NULL,
  `Street` varchar(300) DEFAULT NULL,
  `City` varchar(60) DEFAULT NULL,
  `ZIP` varchar(20) DEFAULT NULL,
  `State` varchar(20) DEFAULT NULL  
);

-- --------------------------------------------------------

--
-- Table structure for table `QR_Jobs`
--

CREATE TABLE IF NOT EXISTS `QR_Jobs` (
  `ID` int(11) NOT NULL,
  `suffix` varchar(10) NOT NULL DEFAULT '',
  `UserID` int(11) NOT NULL,
  `DateQuoted` datetime NOT NULL,
  `StartDate` date NULL DEFAULT NULL,
  `EndDate` date NULL DEFAULT NULL,
  `QuoteType` varchar(120) NOT NULL,
  `Status` varchar(120) NOT NULL,
  `Notes` text  NOT NULL,
  `ClientID` varchar(32)  NOT NULL,
  `ContactID` varchar(32) NOT NULL,
  `WANID` varchar(120) NOT NULL,
  `Street` varchar(300) NOT NULL,
  `City` varchar(60) NOT NULL,
  `ZIP` varchar(20) NOT NULL,
  `State` varchar(20) NOT NULL,
  `internal` tinyint(1) DEFAULT NULL
);

--
-- Table structure for table `QR_JobIDChange`
--

CREATE TABLE `QR_JobIDChange` ( 
  `ID` int(11) NOT NULL,
  `OldJobID` int(11) NOT NULL,
  `NewJobID` int(11) NOT NULL,
  `suffix` varchar(20) NOT NULL DEFAULT '',
  `suffixOld` varchar(20) NOT NULL DEFAULT '',  
  `executed` tinyint(1) NULL DEFAULT NULL
);

-- --------------------------------------------------------

--
-- Table structure for table `QR_TransportRate`
--

CREATE TABLE IF NOT EXISTS `QR_TransportRate` (
  `ID` varchar(36) NOT NULL,
  `ProductAllID` varchar(36) NOT NULL,
  `TruckGroupID` int(11) NOT NULL,
  `Notes` text NOT NULL,
  `MaterialCost` decimal(10,2) NOT NULL,
  `TransportRate` decimal(10,2) NOT NULL,
  `SpecialProject` decimal(10,2) NULL,
  `ExternalTipping` decimal(10,2) NULL
);

--
-- Table structure for table `AWS_Products`
--

CREATE TABLE IF NOT EXISTS `AWS_Products` (
  `CODE` varchar(130) NOT NULL,
  `NAME` varchar(130) NOT NULL,
  `Direction` boolean DEFAULT NULL,
  `Address` varchar(5) DEFAULT NULL
);

--
-- Table structure for table `AWS_ADDRESS`
--

CREATE TABLE IF NOT EXISTS `AWS_ADDRESS` (
  `ID` varchar(10) NOT NULL,
  `Name` varchar(60) NOT NULL,
  `Street` varchar(30) NOT NULL,
  `City` varchar(60) NOT NULL,
  `ZIP` varchar(20) NOT NULL,
  `State` varchar(20) NOT NULL
);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `AWS_ADDRESS`
--
ALTER TABLE `AWS_ADDRESS`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `QR_TruckGroups`
--
ALTER TABLE `QR_TruckGroups`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `AFAllocation`
--
ALTER TABLE `AFAllocation`
  ADD PRIMARY KEY (`ID`,`SiteID`);

--
-- Indexes for table `AWS_Products`
--
ALTER TABLE `AWS_Products`
  ADD PRIMARY KEY (`CODE`);  

--
-- Indexes for table `inputValidation`
--
ALTER TABLE `inputValidation`
  ADD PRIMARY KEY (`ID`);
  
--
-- Indexes for table `Sales`
--
ALTER TABLE `Sales`
  ADD PRIMARY KEY (`ID`,`SiteID`);  

--
-- Indexes for table `AFFuel`
--
ALTER TABLE `AFFuel`
  ADD PRIMARY KEY (`ID`,`AFAllocationID`);

--
-- Indexes for table `ChangeLog`
--
ALTER TABLE `ChangeLog`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `EPA`
--
ALTER TABLE `EPA`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `LaborAllocation`
--
ALTER TABLE `LaborAllocation`
  ADD PRIMARY KEY (`ID`,`SiteID`);

--
-- Indexes for table `StockAdjustments`
--
ALTER TABLE `StockAdjustments`
  ADD PRIMARY KEY (`ID`,`SiteID`,`ProductID`);  
--
-- Indexes for table `LaborFunctions`
--
ALTER TABLE `LaborFunctions`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `LaborList`
--
ALTER TABLE `LaborList`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `LaborStatus`
--
ALTER TABLE `LaborStatus`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `LaborUtilization`
--
ALTER TABLE `LaborUtilization`
  ADD PRIMARY KEY (`ID`,`LaborAllocationID`);

--
-- Indexes for table `Login`
--
ALTER TABLE `Login`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `PlantAllocation`
--
ALTER TABLE `PlantAllocation`
  ADD PRIMARY KEY (`ID`,`SiteID`);

--
-- Indexes for table `PlantUtilization`
--
ALTER TABLE `PlantUtilization`
  ADD PRIMARY KEY (`ID`,`PlantAllocationID`);

--
-- Indexes for table `ProductAllocation`
--
ALTER TABLE `ProductAllocation`
  ADD PRIMARY KEY (`ID`,`SiteID`);

--
-- Indexes for table `ProductGroups`
--
ALTER TABLE `ProductGroups`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `ProductUtilization`
--
ALTER TABLE `ProductUtilization`
  ADD PRIMARY KEY (`ID`,`ProductAllocationID`);

--
-- Indexes for table `Products`
--
ALTER TABLE `Products`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `Recipe`
--
ALTER TABLE `Recipe`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `RecipeRel`
--
ALTER TABLE `RecipeRel`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `SiteList`
--
ALTER TABLE `SiteList`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `SiteNotes`
--
ALTER TABLE `SiteNotes`
  ADD PRIMARY KEY (`ID`,`SiteID`);

--
-- Indexes for table `TransactionTypes`
--
ALTER TABLE `TransactionTypes`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `UpdateLog`
--
ALTER TABLE `UpdateLog`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `TruckGroups`
--
ALTER TABLE `TruckGroups`
  ADD PRIMARY KEY (`ID`);
--
-- AUTO_INCREMENT for dumped tables
--
--
-- Indexes for table `QR_Clients`
--
ALTER TABLE `QR_Clients`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `QR_Contacts`
--
ALTER TABLE `QR_Contacts`
  ADD PRIMARY KEY (`ID`,`ClientID`);

--
-- Indexes for table `QR_JobProducts`
--
ALTER TABLE `QR_JobProducts`
  ADD PRIMARY KEY (`ID`,`JobID`);

--
-- Indexes for table `QR_Jobs`
--
ALTER TABLE `QR_Jobs`
  ADD PRIMARY KEY (`ID`,`suffix`,`UserID`);

--
-- Indexes for table `QR_TransportRate`
--
ALTER TABLE `QR_TransportRate`
  ADD PRIMARY KEY (`ID`,`ProductAllID`);

--
-- Indexes for table `QR_JobIDChange`
--
ALTER TABLE `QR_JobIDChange`
  ADD PRIMARY KEY (`ID`);  

  
--
-- AUTO_INCREMENT for table `QR_JobIDChange`
--
ALTER TABLE `QR_JobIDChange`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `QR_Clients`
--
ALTER TABLE `QR_Clients`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `QR_TruckGroups`
--
ALTER TABLE `QR_TruckGroups`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `QR_Contacts`
--
ALTER TABLE `QR_Contacts`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `QR_Jobs`
--
ALTER TABLE `QR_Jobs`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `TruckGroups`
--
ALTER TABLE `TruckGroups`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `inputValidation`
--
ALTER TABLE `inputValidation`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `AFAllocation`
--
ALTER TABLE `AFAllocation`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `StockAdjustments`
--  
ALTER TABLE `StockAdjustments`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;  
  
--
-- AUTO_INCREMENT for table `Sales`
--
ALTER TABLE `Sales`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
    
--
-- AUTO_INCREMENT for table `AFFuel`
--
ALTER TABLE `AFFuel`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `ChangeLog`
--
ALTER TABLE `ChangeLog`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `EPA`
--
ALTER TABLE `EPA`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `LaborAllocation`
--
ALTER TABLE `LaborAllocation`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `LaborFunctions`
--
ALTER TABLE `LaborFunctions`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `LaborList`
--
ALTER TABLE `LaborList`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `LaborStatus`
--
ALTER TABLE `LaborStatus`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `LaborUtilization`
--
ALTER TABLE `LaborUtilization`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `Login`
--
ALTER TABLE `Login`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `PlantAllocation`
--
ALTER TABLE `PlantAllocation`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `PlantUtilization`
--
ALTER TABLE `PlantUtilization`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `ProductAllocation`
--
ALTER TABLE `ProductAllocation`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `ProductGroups`
--
ALTER TABLE `ProductGroups`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `ProductUtilization`
--
ALTER TABLE `ProductUtilization`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `Products`
--
ALTER TABLE `Products`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `Recipe`
--
ALTER TABLE `Recipe`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `RecipeRel`
--
ALTER TABLE `RecipeRel`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `SiteList`
--
ALTER TABLE `SiteList`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `SiteNotes`
--
ALTER TABLE `SiteNotes`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `TransactionTypes`
--
ALTER TABLE `TransactionTypes`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `UpdateLog`
--
ALTER TABLE `UpdateLog`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
-- Database: `sopsioco_DAR`
--

INSERT INTO `TruckGroups` (`ID`, `GroupName`, `GroupBudget`) VALUES
(1, 'ExBin', '0.00'),
(2, 'Tip Only', '0.00'),
(3, 'T&D', '1500.00'),
(4, 'Quad', '1800.00'),
(5, 'Stag', '1800.00'),
(6, 'TriTri', '2000.00'),
(7, 'Float', '2000.00'),
(8, 'Rigid', '1150.00'),
(9, 'Semi', '1500.00');

INSERT INTO `QR_TruckGroups` (`ID`, `GroupName`) VALUES
(1, 'ExBin'),
(2, 'Tip Only'),
(3, 'T&D'),
(8, 'Rigid'),
(5, 'Stag'),
(9, 'Semi');

INSERT INTO `TransactionTypes` (`ID`, `Description`) VALUES
(1, 'Ingoing'),
(2, 'Outgoing'),
(3, 'Production'),
(4, 'Used in Production');

INSERT INTO `LaborFunctions` (`ID`, `Function`) VALUES
(1, 'Operator'),
(2, 'Weighbridge operator'),
(3, 'Site Manager'),
(4, 'Labour Hire');

INSERT INTO `LaborStatus` (`ID`, `Status`) VALUES
(1, 'IN'),
(2, 'Sick Leave'),
(3, 'RDO'),
(4, 'Annual Leave'),
(5, 'Unpaid Leave'),
(6, 'Public Holiday'),
(7, 'Bereavement Leave');

INSERT INTO `Login` (`ID`, `LoginName`, `Password`, `Rights`, `Status`, `LastUpload`, `LastDownload`, `LastLogin`, `LastActivity`, `Name`, `LastName`) VALUES
(1, 'Menangle', '1b2f2fd7eb2ac23b5ddd383d45233bfe', '{"Rights":1,"Sites":[1]}', 1, '2017-08-21 13:03:00', '2017-08-21 13:01:38', '2017-07-28 18:59:13', NULL, 'Bryan', 'DuMars'),
(2, 'Wallacia', '2fae7330fe63aa996902e0606caa2bc0', '{"SiteID":2,"Rights":1}', 1, '2016-10-26 21:07:58', '2016-11-02 15:11:39', NULL, NULL, 'Jenny', 'Boreland'),
(3, 'Dukester', '2fae7330fe63aa996902e0606caa2bc0', '{"Pages":["dashboard","plantutilization","labourutilization","Sales","Productutilization","Stocks","Transport"],"Rights":1,"Sites":[1,2,3,4,5,6,7,8],"admin":["PlantList","Sales","SalesDel"]}', 1, '2017-08-15 14:24:08', '2017-08-17 21:48:28', '2017-08-17 23:34:13', '2017-08-21 14:27:01', 'Lukas', 'Dulka'),
(4, 'MenDarryl', '64dc40488113b28fd73fd229c98481b6', '{"Pages":["plantutilization","labourutilization","Sales","Productutilization","Stocks"],"Rights":2,"Sites":[1]}', 1, '2017-07-28 19:16:25', '2017-08-16 16:38:37', '2017-08-17 15:12:29', '2017-08-17 15:22:00', 'Daryl', 'Kimmins'),
(6, 'WJenny', 'ec5e1e94c042dda33822701a45eb5e30', '{"SiteID":2,"Rights":1}', 1, '2017-08-12 13:01:18', '2017-08-12 12:50:35', NULL, NULL, 'Jenny', 'Boreland'),
(5, 'WNat', '459a76c655ca62c8052443d2b283d931', '{"Pages":[],"Rights":1,"Sites":[1,2,3,4,7]}', 1, '2017-07-26 22:15:56', '2017-07-26 20:36:41', NULL, NULL, 'Nathaniel', NULL),
(7, 'AdamB', 'f4b97269adcd099d0331429f53534952', '{"Rights":1,"Sites":[3]}', 1, '2017-03-14 20:04:09', '2017-03-22 11:35:34', NULL, NULL, 'Adam', NULL),
(8, 'JamesB', '4163d678e68f506fc9cfb79ef4292a03', '{"Pages":["plantutilization","labourutilization","Sales","Productutilization","Stocks"],"Rights":1,"Sites":[3]}', 1, '2017-08-21 11:36:40', '2017-08-21 11:35:39', NULL, NULL, 'James', 'Myers'),
(9, 'PatricC', 'cb3ce9b06932da6faaa7fc70d5b5d2f4', '{"Rights":2,"Sites":[4]}', 1, '2017-08-21 14:58:35', '2017-08-21 13:58:17', NULL, NULL, 'Patrick', 'O''Donnell'),
(10, 'RichardC', '6cb82956cc751c48ce3e5f3ad306995c', '{"Rights":1,"Sites":[2,4]}', 1, '2017-05-19 21:32:29', '2017-05-19 15:37:36', NULL, NULL, 'Richard', NULL),
(11, 'MenUni', '5c500515b8cdc1f0a1dc69d13b676266', '{"Rights":1,"Sites":[1]}', 1, NULL, NULL, NULL, NULL, 'Menangle', 'Universal'),
(12, 'Minda', '763ec2223f9422bb8c5108e76b47fb0c', '{"Rights":1,"Sites":[5,6]}', 1, '2017-08-21 12:39:51', '2017-08-21 12:34:45', NULL, NULL, 'Karen', 'Scarfi'),
(23, 'MenMatt', '19354f0ea736d0b76268b63a479b0957', '{"Rights":1,"Sites":[1]}', 1, '2016-11-14 19:10:51', NULL, NULL, NULL, NULL, NULL),
(24, 'testUser', '098f6bcd4621d373cade4e832627b4f6', '{"Rights":2,"Sites":[1,2,3,4,5,6]}', 1, NULL, NULL, NULL, NULL, NULL, NULL),
(25, 'RobFraser', 'db0aa20b4a0b1e56016eeb2f39734abd', '{"Pages":["plantutilization","labourutilization","Sales","Productutilization","Stocks","dashboard"],"Rights":1,"Sites":[1,2,3,4,5,6,7,8]}', 1, NULL, '2016-12-14 20:59:49', '2017-08-18 15:11:14', '2017-08-18 15:13:06', 'Rob', 'Fraser'),
(28, 'gleghissa', 'acad1c4c8e2c0a6fe75d7e2f4101bf30', '{"Pages":["plantutilization","labourutilization","Sales","Productutilization","Stocks","dashboard"],"Rights":1,"Sites":[1,2,3,4,5,6,7,8],"admin":["Sales"]}', 1, NULL, NULL, '2017-07-20 14:28:22', '2017-07-20 14:28:33', 'Greg', 'Leghissa'),
(27, 'MattG', '11f085bb34598e11ccb9d95f3c7d8a72', '{"Rights":1,"Sites":[1,2,3,4,5,6,7,8]}', 1, NULL, NULL, NULL, NULL, NULL, NULL),
(29, 'Vanessa', '91273e8cfb21c51c025ce8de2a9231ee', '{"Pages":["plantutilization"],"Rights":1,"Sites":[1,2,3,4,5,6,7,8]}', 1, NULL, NULL, '2017-08-16 13:09:29', '2017-08-16 13:09:29', 'Vanessa', 'Pinto'),
(30, 'StephenH', 'c5049eb9b728ebb609ff39ebd630e4ef', '{"Pages":["plantutilization","labourutilization","Sales","Productutilization","Stocks","dashboard"],"Rights":1,"Sites":[1,2,3,4,5,6,7,8]}', 1, NULL, NULL, NULL, NULL, 'Stephen', 'Hallinan'),
(31, 'VicAshlea', '3a897e12c18f206e9e5b7c157bd38dea', '{"Pages":["plantutilization","labourutilization","Sales","Productutilization","Stocks"],"Rights":1,"Sites":[8]}', 1, '2017-08-17 17:01:05', '2017-08-21 14:57:46', '2017-08-14 16:22:49', '2017-08-14 16:33:35', 'Ashlea', 'Badger'),
(32, 'VicBelinda', 'c89fd6b637f4942dc5f0631e1b5f4148', '{"Pages":["plantutilization","labourutilization","Sales","Productutilization","Stocks"],"Rights":1,"Sites":[8]}', 1, '2017-08-17 21:08:45', '2017-08-17 21:06:23', '2017-08-13 13:47:16', '2017-08-13 13:49:28', 'Belinda', 'Clarke'),
(33, 'VicDavid', '5eaccd4c9b62e98d8d6d096728e23591', '{"Pages":["plantutilization","labourutilization","Sales","Productutilization","Stocks"],"Rights":2,"Sites":[8]}', 1, '2017-08-18 20:57:37', '2017-08-18 20:48:26', '2017-07-14 14:00:54', '2017-07-14 14:06:48', 'David', 'Steinberger'),
(34, 'VicAnita', '83349cbdac695f3943635a4fd1aaa7d0', '{"Pages":["plantutilization","labourutilization","Sales","Productutilization","Stocks"],"Rights":1,"Sites":[8]}', 1, '2017-08-21 12:06:42', '2017-08-21 11:53:47', NULL, NULL, 'Anita', NULL),
(35, 'VicIan', '23009182e3772f5ddcdc368c9be1eae3', '{"Pages":["plantutilization","labourutilization","Sales","Productutilization","Stocks"],"Rights":1,"Sites":[8]}', 1, '2017-08-19 21:21:38', '2017-08-19 20:44:34', NULL, NULL, 'Ian', NULL),
(36, 'VicMark', '1a53eb1fbb83ff55fb34aad377bc0241', '{"Pages":["Sales","Productutilization","Stocks"],"Rights":1,"Sites":[8]}', 1, NULL, NULL, '2017-08-21 13:05:14', '2017-08-21 13:15:05', 'Mark', NULL),
(37, 'VicAshish', 'c2e4feb30ce11a5b31aac58b9d09a62b', '{"Pages":["Sales","Productutilization","Stocks"],"Rights":1,"Sites":[8]}', 1, NULL, NULL, NULL, NULL, 'Ashish', NULL),
(38, 'VicLance', '5c8974a54fee0a6e8f7197e86c289ab9', '{"Pages":["plantutilization","labourutilization","Sales","Productutilization","Stocks"],"Rights":2,"Sites":[8]}', 1, NULL, '2017-07-18 14:24:53', '2017-08-19 04:25:04', '2017-08-19 04:26:25', 'Lance', 'Ingrams'),
(39, 'myTest', '098f6bcd4621d373cade4e832627b4f6', '{"Pages":["plantutilization","labourutilization","Sales","Productutilization","Stocks"],"Rights":1,"Sites":[8]}', 1, NULL, '2017-03-20 18:04:28', NULL, NULL, NULL, NULL),
(40, 'StPaul', '1448d5bb38220059195f2d2c564722fa', '{"Pages":["plantutilization","labourutilization","Sales","Productutilization","Stocks"],"Rights":2,"Sites":[3,7]}', 1, '2017-03-21 17:23:58', '2017-03-21 17:25:35', NULL, NULL, 'Paul', 'McLarnon'),
(41, 'StSatish', 'd572a3ab5f1779215d8be08af28f7c1b', '{"Pages":[],"Rights":1,"Sites":[7]}', 1, '2017-08-18 19:51:04', '2017-08-19 10:42:20', NULL, NULL, 'Satish', NULL),
(58, 'MattHook', '2d4966b4bb3ab6b8ad7a27ad92a6dfef', '{"Pages":[],"Rights":1,"Sites":[1,4]}', 1, '2017-08-19 13:02:03', '2017-08-19 12:27:44', NULL, NULL, 'Mattew', NULL),
(42, 'VicMichael', '2700bf743129d630eb0ba0a05e1ce866', '{"Pages":["Sales","Productutilization","Stocks"],"Rights":1,"Sites":[8]}', 1, NULL, NULL, '2017-08-18 13:14:48', '2017-08-18 13:28:57', 'Michael', NULL),
(43, 'VicTravis', '5ee9867a44ceb3f3faf24b03cb9e3dea', '{"Pages":["Sales","Productutilization","Stocks"],"Rights":1,"Sites":[8]}', 1, NULL, NULL, NULL, NULL, NULL, NULL),
(44, 'kRenee', 'a3fc38515ebded39cc544f07198f4beb', '{"Pages":["plantutilization","labourutilization"],"Rights":1,"Sites":[1,2,3,4,5,6,7,8]}', 1, NULL, NULL, '2017-05-30 13:17:58', '2017-05-30 13:17:58', NULL, NULL),
(45, 'kNastasha', '680a9d9a5e014cd3cd256b3657f3e53d', '{"Pages":["plantutilization","labourutilization"],"Rights":1,"Sites":[1,2,3,4,5,6,7,8]}', 1, NULL, NULL, '2017-06-29 15:38:30', '2017-06-29 15:38:46', NULL, NULL),
(46, 'kNestorovic', '1d9605bb70730e03beaeb002dae9c4fc', '{"Pages":["plantutilization"],"admin":["PlantList"],"Rights":1,"Sites":[1,2,3,4,5,6,7,8]}', 1, NULL, NULL, '2017-08-16 21:29:33', '2017-08-16 21:32:43', 'Stephen', 'Nestrovovic'),
(47, 'BrendaG', 'c8dd8286690f6ca7765d0c68f70fe104', '{"Pages":["dashboard","plantutilization","labourutilization","Sales","Productutilization","Stocks"],"Rights":1,"Sites":[1,2,3,4,5,6,7,8]}', 1, NULL, NULL, '2017-08-16 22:35:21', '2017-08-16 22:38:03', 'Brenda', 'Gaal'),
(48, 'GiuseppeB', '84837a7898dcd998caa1678a33e1c0dd', '{"Pages":["plantutilization","labourutilization","Sales","Productutilization","Stocks","dashboard"],"Rights":1,"Sites":[1,2,3,4,5,6,7,8]}', 1, NULL, NULL, NULL, NULL, 'Giuseppe', 'Bergamin'),
(49, 'BrianH', 'ccbcfe23b2aa86e2eb4c31f09d2b187e', '{"Pages":["plantutilization","labourutilization","Sales","Productutilization","Stocks","dashboard"],"Rights":1,"Sites":[1,2,3,4,5,6,7,8],"admin":["Sales"]}', 1, NULL, NULL, NULL, NULL, 'Bryan', 'Hallinan'),
(50, 'PatH', '178059100d0a78c266755c5c846b847d', '{"Pages":["plantutilization","labourutilization","Sales","Productutilization","Stocks","dashboard"],"Rights":1,"Sites":[1,2,3,4,5,6,7,8]}', 1, NULL, NULL, NULL, NULL, 'Pat', 'Hallinan'),
(51, 'JoeZ', '5dd7d0f9def15aa2feb9d858271d2da2', '{"Pages":["plantutilization","labourutilization","Sales","Productutilization","Stocks","dashboard"],"Rights":1,"Sites":[1,2,3,4,5,6,7,8],"admin":["Sales","SalesDel"]}', 1, NULL, NULL, '2017-05-05 16:27:23', NULL, 'Joe', 'Zappavigna'),
(52, 'BushR', '86554dc5109783d5942f183f71398267', '{"Pages":["plantutilization","labourutilization","Productutilization","Stocks"],"Rights":1,"Sites":[1,2,3,4,5,6,7,8]}', 1, NULL, NULL, '2017-08-07 16:00:30', '2017-08-07 16:01:51', 'Ron', 'Bush'),
(53, 'kKim', '4c0592404f2613a102eae9d057043f4b', '{"Pages":["plantutilization"],"Rights":1,"Sites":[1,2,3,4,5,6,7,8]}', 1, NULL, NULL, '2017-08-18 14:43:25', '2017-08-18 14:43:50', NULL, NULL),
(54, 'Boward', '59fa949c74cdb9d18c6ddbcc906bcfd3', '{"Pages":["plantutilization"],"Rights":1,"Sites":[5,6]}', 1, '2017-07-18 15:22:18', '2017-07-18 15:55:09', NULL, NULL, NULL, NULL),
(55, 'JSmith', 'ca024efa523e3e2f91df50f0b87cac45', '{"Pages":["Productutilization","Stocks"],"Rights":1,"Sites":[1,2,3,4,5,6,7],"admin":["Sales"]}', 1, NULL, NULL, '2017-08-17 15:56:05', '2017-08-17 15:56:05', 'Jayson', 'Smith'),
(56, 'ATogias', 'b4ed4695640820e9c1bad0ec1e899b02', '{"Pages":["Productutilization","Stocks"],"Rights":1,"Sites":[1,2,3,4,5,6,7],"admin":["Sales"]}', 1, NULL, NULL, '2017-08-10 18:39:56', '2017-08-10 18:40:02', 'Arthur', 'Togias'),
(57, 'DarrylB', '33ea3452568ee235c3ce08a7383c5024', '{"Pages":["dashboard","plantutilization","labourutilization","Sales","Productutilization","Stocks"],"Rights":1,"Sites":[1,2,3,4,5,6,7,8]}', 1, NULL, NULL, '2017-05-31 20:01:06', '2017-05-31 20:01:06', 'Darryl', 'Bikoff'),
(59, 'WShirley', 'c509f04bd8c7159f24c006e993c57b0e', '{"Pages":[],"Rights":1,"Sites":[2]}', 1, '2017-08-21 12:16:45', '2017-08-21 12:16:41', NULL, NULL, 'Shirley', 'Shervington'),
(60, 'Leannie', '322556634ac06e54264581b627a7b1c8', '{"Pages":[],"Rights":1,"Sites":[4]}', 1, '2017-08-15 22:11:54', '2017-08-15 19:17:18', NULL, NULL, 'Leannie', NULL),
(61, 'GarryW', 'a1123fcd00631fe25fd818d02326e0cf', '{"Pages":[],"Rights":2,"Sites":[5,6]}', 1, '2017-07-04 19:02:34', '2017-07-04 19:02:29', NULL, NULL, NULL, NULL),
(62, 'MNaughton', 'c02d15b99663e04ca0d059f33441ea33', '{"Pages":[],"Rights":1,"Sites":[1]}', 1, NULL, NULL, NULL, NULL, NULL, NULL),
(63, 'PaulF', '23b26094ffd235d58b477b42927fb334', '{"Pages":[],"Rights":1,"Sites":[3]}', 1, '2017-08-04 20:10:24', '2017-08-04 20:08:53', NULL, NULL, NULL, NULL),
(64, 'RJarrett', 'a3d032bb40811d2a03699e27e4495733', '{"Pages":["Sales","Productutilization","Stocks"],"Rights":1,"Sites":[1,2,3,4,5,6,7],"admin":["Sales"]}', 1, NULL, NULL, '2017-08-08 11:46:29', '2017-08-08 11:51:09', 'Ricky', 'Jarrett'),
(65, 'Riles', '8526687c53d5c44136bf727df7cdcf25', '{"Pages":["plantutilization","labourutilization","Sales","Productutilization","Stocks"],"Rights":1,"Sites":[5,6]}', 1, NULL, NULL, '2017-08-14 20:51:45', '2017-08-14 20:55:00', 'Richard', 'Iles'),
(66, 'ChFarrell', 'aee353a7b257806549782d50d9732fe2', '{"Pages":["Sales"],"Rights":1,"Sites":[1,2,3,4,5,6,7],"admin":["Sales","SalesDel"]}', 1, NULL, NULL, NULL, NULL, 'Chrissie', 'Farrell'),
(68, 'CEvans', 'aee353a7b257806549782d50d9732fe2', '{"Pages":["Sales"],"Rights":1,"Sites":[1,2,3,4,5,6,7],"admin":["Sales"]}', '1', NULL, NULL, NULL, NULL, 'Craig', 'Evans');

INSERT INTO `AWS_Products` (`CODE`, `NAME`, `Direction`, `Address`) VALUES
('WBFILL', ' BULK FILL', NULL, NULL),
('MWS', ' WASHED SAND', NULL, NULL),
('M 10-20GRY', '10-20MM MENANGLE GREY AGG', NULL, 'M'),
('M 10/20CQP', '10/20MM CRUSHED QUARTZ', NULL, 'M'),
('M10QP', '10MM QUARTZ PEBBLE', NULL, NULL),
('M 20/40CQP', '20/40MM CRUSHED QUARTZ', NULL, 'M'),
('M 20/40QP', '20/40MM QUARTZ PEBBLE', NULL, 'M'),
('SM 20CS', '20MM DRAINAGE SLAG', NULL, 'SM'),
('M 20GRY', '20MM MENANGLE GREY', NULL, 'M'),
('M 3070SA', '30-70 SANDSTONE AGG', NULL, 'M'),
('M 4-6MM PEBBLE', '4-6MM PEBBLE', NULL, 'M'),
('SP75CSS', '75 CRUSHED SANDSTONE - SP', NULL, NULL),
('B 10RA', 'B 10MM RECYCLED AGGREGATE', NULL, 'B'),
('GW - B12', 'B 12 - GREEN WASTE', NULL, NULL),
('B 14RRG', 'B 14MM ROUND RIVER GRAVEL', NULL, 'B'),
('B 20-50RRG', 'B 20-50MM ROUND RIVER', NULL, 'B'),
('B 20RA', 'B 20MM RECYCLED AGGREGATE', NULL, 'B'),
('B 20RRB', 'B 20MM RECYCLED ROADBASE', NULL, 'B'),
('B 75CSS', 'B 75MM CRUSHED SANDSTONE', NULL, 'B'),
('B 10BM', 'B BLUE METAL 10MM', NULL, 'B'),
('B CF', 'B CORE FILL', NULL, 'B'),
('B CSPOIL 14', 'B COUNCIL SPOIL CSPOIL 14', NULL, 'B'),
('B CWS', 'B COURSE WASHED SAND', NULL, 'B'),
('B CW20', 'B COWRA WHITE - 20MM', NULL, 'B'),
('B CM', 'B CYPRESS MULCH', NULL, 'B'),
('B ENM', 'B ENM', NULL, 'B'),
('B EM', 'B EUCHI MULCH', NULL, 'B'),
('B FL', 'B FILL SAND', NULL, 'B'),
('B GM', 'B GARDEN MIX', NULL, 'B'),
('B GSW (B&D)', 'B GSW (BUILDING & DEMO)', NULL, 'B'),
('B GSW-REC', 'B GSW - RECYCLABLE', NULL, 'B'),
('B GSW', 'B GSW GENERAL SOLID WASTE', NULL, 'B'),
('B IC SKU', 'B IC SITE CLEANUP', NULL, 'B'),
('B LM', 'B LEAF MULCH', NULL, 'B'),
('B LS20', 'B LIMESTONE PEBBLE - 20MM', NULL, 'B'),
('B SS', 'B NEWCASTLE SAND', NULL, 'B'),
('B PP', 'B PAPER PULP', NULL, 'B'),
('B PB15', 'B PINEBARK - 15MM', NULL, 'B'),
('B RSND', 'B REC BRICK/CONCRETE SAND', NULL, 'B'),
('B RMAT', 'B RECYCLABLE MATERIAL', NULL, 'B'),
('B RWC', 'B REDWOOD CHIP', NULL, 'B'),
('B SB', 'B SANDSTONE BOULDERS', NULL, 'B'),
('B SCRAP METAL', 'B SCRAP METAL', NULL, 'B'),
('B SWS', 'B SINGLE WASHED SAND', NULL, 'B'),
('B SCU', 'B SITE CLEANUP', NULL, 'B'),
('B SKU', 'B SKIP CLEAN', NULL, 'B'),
('B STAB', 'B STABILISED SAND', NULL, 'B'),
('B TD', 'B TOP DRESSING', NULL, 'B'),
('B TS', 'B TOP SOIL', NULL, 'B'),
('B TU', 'B TURF UNDERLAY/ REC SOIL', NULL, 'B'),
('B VENM', 'B VENM', NULL, 'B'),
('B WBS', 'B WHITE BRICK SAND', NULL, 'B'),
('B YBS', 'B YELLOW BRICK SAND', NULL, 'B'),
('B10 GSW - RETURNED', 'B10 GSW - REEDS RETURNED', NULL, NULL),
('RW-B10', 'B10-RECYCLEABLE WASTE', NULL, NULL),
('B11', 'B11 UNRECYCLEABLE WASTE', NULL, NULL),
('B13', 'B13 TIMBER WASTE', NULL, NULL),
('B9', 'B9 - CLEAN CLAY', NULL, NULL),
('M BDS', 'BEDDING SAND', NULL, 'M'),
('BICENM', 'BICENM', NULL, NULL),
('BICVENM', 'BICVENM', NULL, NULL),
('S BGM', 'BUDGET GARDEN MIX', NULL, NULL),
('M CLAY', 'CLAY FILL', NULL, 'M'),
('S CTT', 'CRUSHED TERACOTTA  TILE', NULL, NULL),
('M 10/20GRY', 'M 10-20MM MENANG GREY AGG', NULL, 'M'),
('M10/20RA', 'M 10/20MM RECYCLED AGG', NULL, NULL),
('M 150-300G', 'M 150-300MM GABION', NULL, 'M'),
('M 20-40RRG', 'M 20-40 ROUND RIVERGRAVEL', NULL, 'M'),
('M RRB', 'M 20MM RECYCLED ROADBASE', NULL, 'M'),
('M 3070GRY', 'M 30-70MM MENANGLE GREY', NULL, 'M'),
('M 300-500B', 'M 300-500MM BOULDER', NULL, 'M'),
('M 4070SA', 'M 40-70 SANDSTONE AGG', NULL, 'M'),
('M 40CSS', 'M 40MM CRUSHED SANDSTONE', NULL, 'M'),
('M 40+RRG', 'M 40MM+ ROUND RIVERGRAVEL', NULL, 'M'),
('M 5-7 SSP', 'M 5-7 MM SANDSTONE PEBBLE', NULL, 'M'),
('M 500-800B', 'M 500-800MM BOULDER', NULL, 'M'),
('M 50CSS', 'M 50MM CS SANDSTONE', NULL, 'M'),
('M 50MM CSS R57', 'M 50MM CS SANDSTONE R57', NULL, 'M'),
('M 75-150G', 'M 75-150MM GABION', NULL, 'M'),
('M 75CSS', 'M 75MM CRUSHED SANDSTONE', NULL, 'M'),
('M 75CSSM', 'M 75MM CSS MULCH', NULL, 'M'),
('M PROP', 'M <6MM PROPERGATING SAND', NULL, 'M'),
('M ARMOUR', 'M ARMOUR ROCK 800+', NULL, 'M'),
('M ROTAR 8', 'M ASPHALT/ ROADBASE', NULL, 'M'),
('M BESA', 'M BEDDING SAND', NULL, 'M'),
('M BFS', 'M BLENDED FILL SAND', NULL, 'M'),
('M BLSH', 'M BLUE SHALE', NULL, 'M'),
('M BRK 5', 'M BRICK BRK 5', NULL, 'M'),
('M BRICK/CONC 6', 'M BRICK/CONCRETE  MIX', NULL, 'M'),
('M CLEAN', 'M CLEAN BRICK & CONCRETE', NULL, 'M'),
('CC MEN MED 1', 'M CONCRETE - MED 1', NULL, NULL),
('M CC-NIL', 'M CONCRETE - NIL CHARGE', NULL, 'M'),
('M CSND', 'M CONCRETE SAND', NULL, 'M'),
('M DWS', 'M DOUBLE WASHED SAND', NULL, 'M'),
('M HGCS', 'M HIGH GRADE COMPACT SND', NULL, 'M'),
('MICB300500', 'M IC BOULDER 300-500', NULL, NULL),
('MICB500800', 'M IC BOULDER 500-800', NULL, NULL),
('MICCC1500', 'M IC CLEAN CON UP TO 1500', NULL, NULL),
('MICCB', 'M IC CLEN BRICK', NULL, NULL),
('MICCSS40', 'M IC CRUSH S.STONE 40', NULL, NULL),
('MICCSS75', 'M IC CURSH SSTONE 75', NULL, NULL),
('MICG75150', 'M IC G 75-150', NULL, NULL),
('MICCG150300', 'M IC GABION 150-300', NULL, NULL),
('MICSEL', 'M IC NON SPEC FILL', NULL, NULL),
('MICP612', 'M IC PEBBLES 6-12', NULL, NULL),
('MICRDGB20', 'M IC RECYCLED DGB20', NULL, NULL),
('MICRRB20', 'M IC RECYCLED RB20', NULL, NULL),
('MICWS', 'M IC WASHED SAND', NULL, NULL),
('M CC MED 2', 'M MENANGLE CC MED 2', NULL, 'M'),
('M  CLAY', 'M MENANGLE CLAY', NULL, 'M'),
('M DST', 'M MENANGLE DUST', NULL, 'M'),
('M MIXED', 'M MIX BRICK CONCRETE DIRT', NULL, 'M'),
('M BRK/CC/6', 'M MIXED BRICK & CONCRETE', NULL, 'M'),
('M NP ROADBASE', 'M NP ROADBASE', NULL, 'M'),
('+6 -120 WR', 'M O +6 -120 WASHED ROCK', NULL, NULL),
('M PULP', 'M PULP', NULL, 'M'),
('M RSND', 'M RECYCLED BRK-CON SAND', NULL, 'M'),
('M RDGB20', 'M RECYCLED DGB20', NULL, 'M'),
('ASHPHALT', 'M ROTAR 7', NULL, NULL),
('M SCRAP METAL', 'M SCRAP METAL', NULL, 'M'),
('M SFS', 'M SCREENED FILL SAND', NULL, 'M'),
('M SEL', 'M SELECT FILL', NULL, 'M'),
('M VENM', 'M VENM', NULL, 'M'),
('M WFS', 'M WASHED FILL SAND', NULL, 'M'),
('M SWS', 'M WASHED SAND', NULL, 'M'),
('M WSN1', 'M WASHED SAND NUMBER 1', NULL, 'M'),
('M WBS', 'M WHITE BRICK SAND', NULL, 'M'),
('M WS - 5% STAB', 'M WS - 5% STABILISED', NULL, 'M'),
('M WS', 'M WS SAND', NULL, 'M'),
('M YBS', 'M YELLOW BRICK SAND', NULL, 'M'),
('M1', 'M1-CLEAN CONCRETE', NULL, NULL),
('M 10-20CRG', 'M10-20CRUSHED RIVERGRAVEL', NULL, 'M'),
('M2', 'M2-CLEAN CONCRETE', NULL, NULL),
('M3', 'M3-CLEAN CONCRETE', NULL, NULL),
('M4', 'M4-CLEAN CONCRETE', NULL, NULL),
('BRK-M5', 'M5-CLEAN BRICKS', NULL, NULL),
('M 6-12SSP', 'M6-12MM SANDSTONE PEBBLE', NULL, 'M'),
('BC-M6', 'M6-BRICKS & CONCRETE', NULL, NULL),
('OLD STOCK SAND', 'O OLD STOCK PILE SAND', NULL, NULL),
('RELOAD', 'RELOAD', NULL, NULL),
('SM RCU', 'REMEDIATION CLEAN UP', NULL, 'SM'),
('S 10RA', 'S 10MM RECYCLED AGG', NULL, NULL),
('S 20RA', 'S 20MM RECYCLED AGG', NULL, NULL),
('SM 20RRB', 'S 20MM RECYCLED ROADBASE', NULL, 'SM'),
('SM 30/50RA', 'S 30-50MM RECYCLED AGG', NULL, 'SM'),
('S 30/70 REC AGG', 'S 30-70 RECYCLED AGG', NULL, NULL),
('S 5/20 BRICK AGG', 'S 5/20 BRKA   EX BIN', NULL, NULL),
('S 70-30BS', 'S 70-30 BLENDED SOIL', NULL, NULL),
('S 75CSS', 'S 75MM CRUSHED SANDSTONE', NULL, NULL),
('SM ROTAR 7', 'S ASPHALT ROTAR  7', NULL, 'SM'),
('SM ROTAR 8', 'S ASPHALT ROTAR 8', NULL, 'SM'),
('SM BRK 5', 'S BRICK  BRK 5', NULL, 'SM'),
('SM BRB', 'S BRICK ROAD BASE', NULL, 'SM'),
('SM BRK/CONC 6', 'S BRICK/CONCRETE MIX', NULL, 'SM'),
('B CSI', 'S COMP/ SOIL IMPROVER IN', NULL, 'B'),
('S CSI', 'S COMPOST/ SOIL IMPROVER', NULL, NULL),
('SM CC LRG 4', 'S CONCRETE  CC LRG 4', NULL, 'SM'),
('SM CC LRG 3', 'S CONCRETE CC LRG 3', NULL, 'SM'),
('SM CC MED 1', 'S CONCRETE CC MED 1', NULL, 'SM'),
('SM CC MED 2', 'S CONCRETE CC MED 2', NULL, 'SM'),
('SM CSPOIL 14', 'S COUNCIL SPOIL CSPOIL 14', NULL, 'SM'),
('SM CWASTE 15', 'S COUNCIL WASTE CWASTE 15', NULL, 'SM'),
('SM FILL SOIL', 'S FILL SOIL', NULL, 'SM'),
('SM FSLUDGE16', 'S FILTER SLUDGE 16', NULL, 'SM'),
('S GM', 'S GARDEN MIX', NULL, NULL),
('SM GWASTE 11', 'S GENERAL C&D WASTE 11', NULL, 'SM'),
('SM M/MASONRY 10', 'S MIXED MASONRY 10', NULL, 'SM'),
('SM RAP', 'S RECYCLED ASPHALT', NULL, 'SM'),
('SM RSND', 'S RECYCLED BRK-CON SAND', NULL, 'SM'),
('SM RDGB20', 'S RECYCLED DGB20', NULL, 'SM'),
('S RSND-B', 'S RECYCLED SAND - EX BIN', NULL, NULL),
('S RSND-T', 'S RECYCLED SAND - T & D', NULL, NULL),
('S SCRAP METAL', 'S SCRAP METAL', NULL, NULL),
('S SHALE', 'S SHALE', NULL, NULL),
('SM SOLCLYDRT 9', 'S SOIL-CLAY- DIRT 9', NULL, 'SM'),
('SM TIMBWAST LRG 13', 'S TIMBER WASTE LRG 13', NULL, 'SM'),
('SM TIMBWAST SML 12', 'S TIMBER WASTE SML 12', NULL, 'SM'),
('SM TU', 'S TURF UNDERLAY', NULL, 'SM'),
('S VENM', 'S VENM', NULL, NULL),
('M SSB', 'SELECT SAND BLEND', NULL, 'M'),
('SM CC-NIL', 'SM CONCRETE - NIL CHARGE', NULL, 'SM'),
('SM ENM', 'SM ENM', NULL, 'SM'),
('SM GSW (B&D)', 'SM GSW (BUILDING & DEMO)', NULL, 'SM'),
('SM GSW - REC', 'SM GSW - RECYCLABLE', NULL, 'SM'),
('SM GSW', 'SM GSW GENERAL SOLID WAST', NULL, 'SM'),
('SMICAC', 'SM IC ASPHALT CLEAN', NULL, NULL),
('SMICARE', 'SM IC ASPHALT RECYCLED', NULL, NULL),
('SMICARI', 'SM IC ASPHALT RIPPED', NULL, NULL),
('SMICBC', 'SM IC BRICK & CONCRETE', NULL, NULL),
('SMICCB', 'SM IC CLEAN BRICK', NULL, NULL),
('SMICCC500', 'SM IC CLEAN CON UP TO 500', NULL, NULL),
('SMICCC1500', 'SM IC CLEAN CONC OVER 1.5', NULL, NULL),
('SMICCNC', 'SM IC CONCRETE - NIL CHGE', NULL, NULL),
('SMICENM', 'SM IC ENM', NULL, NULL),
('SMICGW', 'SM IC GREEN WASTE', NULL, NULL),
('SMICGSW', 'SM IC GSW', NULL, NULL),
('SMICGSWBD', 'SM IC GSW (BUILD DEMO)', NULL, NULL),
('SMICGSWR', 'SM IC GSW-RECYCLABLE', NULL, NULL),
('SMICRW', 'SM IC RECYCLABLE WASTE', NULL, NULL),
('SMICRS', 'SM IC RECYCLE BRK-CON SAN', NULL, NULL),
('SMICRA10', 'SM IC RECYCLED AGG 10', NULL, NULL),
('SMICRA20', 'SM IC RECYCLED AGG 20', NULL, NULL),
('SMICRA3070', 'SM IC RECYCLED AGG 30-70', NULL, NULL),
('SMICRDGB20', 'SM IC RECYCLED DGB20', NULL, NULL),
('SMICRELOAD', 'SM IC RELOAD', NULL, NULL),
('SMICSBDW', 'SM IC SB AND D WASTE', NULL, NULL),
('SMICSM', 'SM IC SCRAP METAL', NULL, NULL),
('SM IC SKU', 'SM IC SITE CLEANUP', NULL, 'SM'),
('SMICUW', 'SM IC UNRECYCLABLE WASTE', NULL, NULL),
('SMICWBNC', 'SM IC USE HQ WBRIDGE N/C', NULL, NULL),
('SMICVENM', 'SM IC VENM', NULL, NULL),
('SMICRRB20', 'SM MIC RECYCLED RB20', NULL, NULL),
('PULP', 'SM PULP', NULL, NULL),
('SM RMAT', 'SM RECYCLABLE MATERIAL', NULL, 'SM'),
('SM SBDWASTE', 'SM SB AND D WASTE OUT', NULL, 'SM'),
('SM SCRAP METAL', 'SM SCRAP METAL', NULL, 'SM'),
('SM SCU', 'SM SITE CLEANUP', NULL, 'SM'),
('SM SKU', 'SM SKIP CLEAN', NULL, 'SM'),
('SM1', 'SM1-CLEAN CONCRETE', NULL, NULL),
('RW-SM10', 'SM10-RECYCLEABLE WASTE', NULL, NULL),
('UW-SM11', 'SM11-UNRECYCLEABLE WASTE', NULL, NULL),
('GW-SM12', 'SM12-GREEN WASTE', NULL, NULL),
('TW-SM13', 'SM13-TIMBER WASTE', NULL, NULL),
('SM2', 'SM2-CLEAN CONCRETE', NULL, NULL),
('SM3', 'SM3-CLEAN CONCRETE', NULL, NULL),
('SM4', 'SM4-CLEAN CONCRETE', NULL, NULL),
('BRK-SM5', 'SM5-CLEAN BRICKS', NULL, NULL),
('BCA-SM6', 'SM6-BRICK & CONCRETE', NULL, NULL),
('A-SM7', 'SM7-CLEAN ASPHALT', NULL, NULL),
('A-SM8', 'SM8-RIPPED ASPHALT', NULL, NULL),
('SM88', 'SM88 BROKEN ASPHALT', NULL, NULL),
('CL-SM9', 'SM9-CLEAN CLAY', NULL, NULL),
('TEST222222222222222222222', 'TEST111111111111111111111', NULL, NULL),
('USE HIQ WEIGHBRIDGE N/C', 'USE HIQ WEIGHBRIDGE N/C', NULL, NULL),
('GENERAL WEIGH', 'USE OF HIQ WEIGHBRIDGE', NULL, NULL),
('W 150-300G', 'W 150-300MM GABION', NULL, 'W'),
('W300-500B', 'W 300-500 BOULDER', NULL, NULL),
('W 300/500B', 'W 300-500MM BOULDER', NULL, 'W'),
('W 500-800B', 'W 500-800MM BOULDER', NULL, 'W'),
('W 50CSS', 'W 50MM CRUSHED SANDSTONE', NULL, 'W'),
('W 50CSS - R57', 'W 50MM CSS - R57', NULL, 'W'),
('W 75/150G', 'W 75-150MM GABION', NULL, 'W'),
('W 75CSS - 5% STAB', 'W 75CSS - 5% STABILISED', NULL, 'W'),
('W 75CSS-BCC CRUSHED SS', 'W 75CSS-BCC CRUSHED SS', NULL, 'W'),
('W 75CSS', 'W 75MM CRUSHED SANDSTONE', NULL, 'W'),
('W 75MM CSS - R57', 'W 75MM CSS - R57 EX BIN', NULL, 'W'),
('W 75MM CSS - R57 RIGID', 'W 75MM CSS - R57 RIGID', NULL, 'W'),
('W 75MM CSS - R57 T & D', 'W 75MM CSS - R57 T & D', NULL, 'W'),
('W 75MM CSS EX BIN', 'W 75MM CSS EX BIN', NULL, 'W'),
('W 75MM CSS', 'W 75MM CSS T & D', NULL, 'W'),
('W 100CSS', 'W <100MM SANDSTONE', NULL, 'W'),
('W ARMOUR', 'W ARMOUR ROCK 800+', NULL, 'W'),
('W ENM', 'W ENM', NULL, 'W'),
('W ENM - NON COMPACT', 'W ENM - NON COMPACT', NULL, 'W'),
('W ENM EX', 'W ENM EXEMPT', NULL, 'W'),
('W ENM SPADEABLE', 'W ENM SPADEABLE', NULL, 'W'),
('W GBF', 'W GBF', NULL, 'W'),
('WICA800', 'W IC ARMOUR ROCK 800+', NULL, NULL),
('WICB500800', 'W IC BOULDER 500-800', NULL, NULL),
('WICBSHALE', 'W IC BROWN SHALE', NULL, NULL),
('WICCSS75T', 'W IC CRUCH SSTONE 75 T&D', NULL, NULL),
('WICCSS75', 'W IC CRUSH SSTONE 75', NULL, NULL),
('WICENM', 'W IC ENM', NULL, NULL),
('WICG150300', 'W IC GABION 150-300', NULL, NULL),
('WICG75150', 'W IC GABION 75-150', NULL, NULL),
('WICWS', 'W IC SMINE/WASHED SAND', NULL, NULL),
('WICVENM', 'W IC VENM', NULL, NULL),
('WICWQP', 'W IC WASH QUARTZ PEBBLE', NULL, NULL),
('W SCRAP METAL', 'W SCRAP METAL', NULL, 'W'),
('W SEL', 'W SELECT FILL', NULL, 'W'),
('W VENM', 'W VENM', NULL, 'W'),
('W VENM - NON COMPACT', 'W VENM - NON COMPACT', NULL, 'W'),
('W VENM SPADEABLE', 'W VENM SPADEABLE', NULL, 'W'),
('WD ASHT', 'WD ASBESTOS SHEET', NULL, 'WD'),
('WD ABS', 'WD ASBESTOS SOIL', NULL, 'WD'),
('WD ASB BD', 'WD ASBESTOS SOIL B&D', NULL, 'WD'),
('WD ASB DEMO', 'WD ASBESTOS WASTE (B&D)', NULL, 'WD'),
('WDGSWCD', 'WD GEN SOLID WASTE C & D', NULL, NULL),
('WD GSW', 'WD GSW', NULL, 'WD'),
('WD IC RDGB20', 'WD IC RDGB20', NULL, 'WD'),
('WD LFA', 'WD LFA', NULL, 'WD'),
('WD SCRAP METAL', 'WD SCRAP METAL', NULL, 'WD'),
('253', 'WD TEST', NULL, NULL),
('254', 'WD TEST 1', NULL, NULL),
('WD TYRES', 'WD TYRES', NULL, 'WD'),
('WD WHITE CLAY', 'WD WHITE CLAY', NULL, 'WD'),
('WD WOODWASTE', 'WD WOODWASTE', NULL, 'WD'),
('PROP SAND', '5mm Blend RRP', NULL, NULL),
('OA 10 RRP', '10mm Blend RRP', NULL, 'OA'),
('OA 20 RRP', '20mm Blend RRP', NULL, 'OA'),
('OA 40 RRP', '40mm Blend RRP', NULL, 'OA'),
('OA C SND', 'Course Concrete Sand 3mm', NULL, 'OA'),
('OA 80/20 SND', 'Propagating Sand 80/20 Mix', NULL, 'OA');

INSERT INTO `PlantList` (`ID`, `PlantDesc`, `Rate`, `UnitOfMeasurement`) VALUES
('P01', 'Caterpillar 936 Loader Sand & Soil Yard', '297.50', 'h'),
('U50', 'Mitsubishi 4T Single Axle Tipper Rego BI36EY', '94.50', 'h'),
('U51', 'Mitsubishi 3T Single Axle Tipper Rego BZ32DN', '94.50', 'h'),
('U52', 'Mitsubishi 3T Single Axle Tipper Rego BZ33DN', '94.50', 'h'),
('U150', 'Feightliner Twin Steer Tipper Rego CD60ZZ', '294.00', 'h'),
('U154', 'Freightliner Twin Steer Tipper AH83RP', '294.00', 'h'),
('U153', 'Freightliner Twin Steer Tipper AH04RQ', '294.00', 'h'),
('U53', 'Mistubishi 9T Single Axle Tipper Rego BZ60NI', '168.00', 'h'),
('U54', 'Mistubishi 6T Single Axle  RegoCA93DI Skip Bin Truck', '200.00', 'h'),
('U159', '12T Sterling CH50RS', '277.20', 'h'),
('U160', '12T Sterling CI97DG', '277.20', 'h'),
('U157', 'Sterling Bogie  Tipper AK86OE Check Utilization', '277.20', 'h'),
('U158', 'Sterling Bogie  Tipper CG80XG', '277.20', 'h'),
('P20', 'Leader Watercart', '277.20', 'h'),
('U31', 'Sterling Bogie  Tipper C73PT Retired to KC Yard', '277.20', 'h'),
('P157', 'Volvo EC460BL Exc', '619.50', 'h'),
('P158', 'Volvo EC460BL Exc', '619.50', 'h'),
('P173', 'Extec S-6 Screen', '1120.00', 'h'),
('P195', 'Komatsu D375A-5 Dozer', '1400.00', 'h'),
('P200', 'Komatsu WA 470-6 Loader', '385.00', 'h'),
('P201', 'Acco Watercart Kilometer', '277.20', 'h'),
('P205', 'Komatsu WF550T-3 Compactor', '802.90', 'h'),
('P209', 'Komatsu WA470-6 Loader', '385.00', 'h'),
('P216', 'UD Watercart Bogie', '277.20', 'h'),
('P217', 'UD Watercart', '277.20', 'h'),
('P234', 'Metso Nordberg LT 1213S Impact Crusher', '1960.00', 'h'),
('P238', 'Komatsu WA 470-6 Loader', '385.00', 'h'),
('P239', 'Komatsu WA 470-6 Loader', '385.00', 'h'),
('P249', 'Komatsu WA 500-6 Loader', '620.90', 'h'),
('P250', 'Volvo A40F Dump Truck', '626.50', 'h'),
('P251', 'Volvo A40F Dump Truck', '626.50', 'h'),
('P252', 'Caterpillar D8R Dozer', '700.00', 'h'),
('P255', 'Komatsu WA 500-6 Loader', '620.90', 'h'),
('P258', 'Komatsu D475A-5 Dozer', '2100.00', 'h'),
('P264', 'Caterpillar CS563 Smooth Drum 12T Roller', '182.00', 'h'),
('P265', 'Caterpillar CP533 Padfoot 12T Roller', '182.00', 'h'),
('P268', 'Hyundai R5.5-9 Exc', '202.30', 'h'),
('P269', 'Hyundai R80CR-9 Exc', '224.00', 'h'),
('P270', 'Hyundai R145CDR-9 Exc', '281.40', 'h'),
('P273', 'Caterpillar  140M Grader Fitted For Gps', '420.00', 'h'),
('P274', 'Caterpillar 12H Grader', '347.90', 'h'),
('P275', 'Caterpillar CP533 Padfoot 12T Roller', '182.00', 'h'),
('P277', 'Caterpillar CB14 Tandem Smooth Drum 1.4T Roller', '87.50', 'h'),
('P278', 'Bobcat S590 ', '154.70', 'h'),
('P279', 'Bobcat S650', '175.00', 'h'),
('P280', 'Bobcat T650 Pozzi Track', '201.60', 'h'),
('P282', 'Mitsubishi Watercart Single Axle Standpipe YREE0008', '217.00', 'h'),
('P286', 'Caterpillar CB22  BK Tandem Smooth Drum 2.5T Roller', '87.50', 'h'),
('P287', 'Caterpillar 345 Exc', '619.50', 'h'),
('P290', 'Metso Locotrack LT 3054 Crusher', '1960.00', 'h'),
('P293', 'Komatsu HM 400-2 Dump Truck Tail Gate', '626.50', 'h'),
('P299', 'Komatsu PC200 LC-8 Exc', '329.00', 'h'),
('P303', 'Keestrack Frontier Screen', '840.00', 'h'),
('P305', 'Keestrack Frontier Screen', '840.00', 'h'),
('P306', 'Keestrack Frontier Screen', '840.00', 'h'),
('P312', 'Caterpillar  CB22B Dual Smooth Drum Roller 2.5T', '87.50', 'h'),
('P314', 'Bobcat T650 Pozzi Track', '201.60', 'h'),
('P316', 'Komatsu WA480- Loader', '441.00', 'h'),
('P320', 'Isuzu FVZ1400 13Kl Watercart Rego CH52RS', '277.20', 'h'),
('P325', 'Caterpillar 980G Loader', '620.90', 'h'),
('P327', 'Komatsu WA470-6', '385.00', 'h'),
('P328', 'Isuzu  FVZ1400 13Kl Watercart Rego CF00YI', '277.20', 'h'),
('P329', 'Caterpillar  IT62G Tool Carrier, Bucket,Man Basket,Forks & Jib', '297.50', 'h'),
('P186', 'Extec S-5 Screen', '1008.00', 'h'),
('P206', 'Komatsu WA 470-6 Loader', '385.00', 'h'),
('P212', 'Komatsu WA 380-6 Loader Traded for P327 27/11/15', '350.00', 'h'),
('P297', 'Komatsu PC200 LC-8 Exc Grabs, Dig, B/Bucket, Sieve Bucket', '329.00', 'h'),
('P309', 'Komatsu PC450LC-8 Case Drain', '619.50', 'h'),
('P317', 'Keestrack Frontier Scalper Purchased from Sceenmaster 28/9/15', '840.00', 'h'),
('P332', 'Keestrack Screen Purchased from Sceenmaster 23/4/16', '840.00', 'h'),
('T07', 'Single Axle Tag Along Trailer Rego Z93797', '140.00', 'h'),
('T08', 'Single Axle Tag Along Trailer Rego TA03UQ', '140.00', 'h'),
('U57', 'Spare Site Clean Bogie - STEVE SEE CRYSTAL', '277.20', 'h'),
('P133', 'Volvo A30D  Dump Truck', '461.30', 'h'),
('P148', 'Metso Nordberg NP 1213-m Impactor Crusher', '1960.00', 'h'),
('P150', 'Volvo A30D Dump Truck', '461.30', 'h'),
('P184', 'Extec S-5 Screen  ( In Grave Yard )', '1008.00', 'h'),
('P199', 'Adelaide Chieftain 1400 Screen', '1008.00', 'h'),
('P221', 'Finlay 7702002 Trommel', '1120.00', 'h'),
('P266', 'Caterpillar 825H Compactor', '802.90', 'h'),
('P267', 'Hyundai R5.5-9 Exc', '202.30', 'h'),
('P271', 'Hyundai R235LCR-9 Exc', '359.80', 'h'),
('P272', 'Caterpillar 140M Grader', '420.00', 'h'),
('P276', 'Cat CS573 Smooth Drum Roller 14T', '182.00', 'h'),
('P281', 'Mitsubishi Watercart Single Axle Standpipe YREE0007', '217.00', 'h'),
('P284', 'Hyundai 320LC-9 Exc', '525.00', 'h'),
('P291', 'Komatsu HM 400-2 Dump Truck NoTail Gate', '626.50', 'h'),
('P292', 'Komatsu HM 400-2 Dump Truck Tail Gate', '626.50', 'h'),
('P295', 'Komatsu PC138-8 US Exc', '281.40', 'h'),
('P301', 'Caterpillar D10N Dozer', '1400.00', 'h'),
('P308', 'Komatsu PC450LC-8', '619.50', 'h'),
('P310', 'Komatsu GD655 Grader Fitted For Gps', '347.90', 'h'),
('P318', 'Volvo EC480DL Excavator Fitted For Gps', '619.50', 'h'),
('P326', 'Caterpiller D11T Dozer', '2100.00', 'h'),
('Allcott Hire', '6" Pump, 200m Delivery Line, 12m Suction Line C/W Foot Valve', '0.00', 'h'),
('P126', 'Hitachi ZX 480 Exc', '619.50', 'h'),
('P181', 'Chieftain EG 2100 Screen', '1080.00', 'h'),
('P190', 'Komatsu PC450-8 LC Exc', '619.50', 'h'),
('P207', 'Komatsu WA 470-6 Loader', '385.00', 'h'),
('P229', 'Metso LT7150 Barmac Crusher Sold/Traded', '1960.00', 'h'),
('P237', 'Komatsu WA 470-6 Loader', '385.00', 'h'),
('P246', 'Screenmaster Frontier Scalper (Keestrac) Screen', '840.00', 'h'),
('P289', 'Metso Nordberg LT 1315S Impact Crusher', '1960.00', 'h'),
('P298', 'Komatsu PC270 LC-8 Exc Dig & Batter Buckets Remeadiation', '386.40', 'h'),
('P331', 'Keestrack 1313S Impact Crusher', '2800.00', 'h'),
('P26', '5140 Case Tractor', '0.00', 'h'),
('P153', '4 Cyl GM Pump 150mm Self Priming', '0.00', 'h'),
('P155', 'Komatsu D85 Dozer', '595.00', 'h'),
('P176', 'Perkins & 100mm Water Pump', '0.00', 'h'),
('P190A', 'Yanmar Diesel Flex Drive Pump', '0.00', 'h'),
('P210', 'Komatsu PC450-7 Excavator', '619.50', 'h'),
('P219', 'Sline Water Cart', '277.20', 'h'),
('P232', 'Deutz 100mm Water Pump', '0.00', 'h'),
('U274', 'Caterpillar 12H Grader', '347.90', 'h'),
('P302', 'Aston Atomiser 1600', '616.00', 'h'),
('P315', 'Caterpillar 836H Trash Compactor', '802.90', 'h'),
('U221', 'Service Truck 4 x 4 C/W Tools (Tools List In Plant Folder W''shop Office)', '0.00', 'h'),
('P143', 'Weighbridge Gen Set (in Container 25KVA)', '0.00', 'h'),
('P142', 'Diesel 6" Pump House Pump', '0.00', 'h'),
('P178', 'MT 1440 Manitou Tele Handler Forklift & Bucket', '277.20', 'h'),
('P179', 'Washery Gen Set 1135 KVA', '0.00', 'h'),
('P182', 'Caterpillar Water Pump 150mm x 125mm', '0.00', 'h'),
('P123', 'Ford 900 Watercart', '277.20', 'h'),
('P228', '4 Cyl Ford Motor & Grundfos Water Pump', '0.00', 'h'),
('P253', 'Tesab Jaw Crusher', '1400.00', 'h'),
('Attach', 'Dig Bucket & Ripper For P287', '0.00', 'h'),
('P288', 'Caterpillar 815F Compactor', '452.20', 'h'),
('P135', 'Genset #2 Runs P151  Wash Pant', '0.00', 'h'),
('P144', 'TQS Mobile Radial Stacker S-62685 Conveyor (Fixed Plant Item)', '0.00', 'h'),
('P162', 'Diesel Generator', '0.00', 'h'),
('P163', 'Cummins 100 KVA Genset & 6" Submersable Pump', '0.00', 'h'),
('P208', 'Komatsu WA 470-6 Loader', '385.00', 'h'),
('P222', 'Komatsu PC710-5 Exc Long Reach', '1820.00', 'h'),
('P240', 'Komatsu PC800-6 Exc', '1225.00', 'h'),
('P241', 'Track Stacker Conveyor', '420.00', 'h'),
('P245', 'VSI 2000 (Blown Motor) Crusher', '0.00', 'h'),
('P283', 'Iveco Watercart Kilometer', '277.20', 'h'),
('P294', 'Caterpillar D11R Dozer', '2100.00', 'h'),
('P300', 'Caterpillar 325 Exc', '359.80', 'h'),
('P304', ' Gipo Mag 2700 Vertical Shaft Impactor (Crusher)', '2800.00', 'h'),
('P319', 'Keestrack 230 Track Stacker', '420.00', 'h'),
('P12', 'Perkins Generator Weighbridge', '0.00', 'h'),
('P39', 'Powerscreen M100 Mobile Screen', '1008.00', 'h'),
('P79', 'Dredge 4Cyl Caterpillar & Goodwin Sand Pump', '0.00', 'h'),
('P89', 'Powerscreen 620 Trommel', '0.00', 'h'),
('P93', 'Stationary Trommel', '0.00', 'h'),
('P99', 'Water Pump 471 Detroit Pump', '0.00', 'h'),
('P140', 'Komatsu WA 500-3H Loader', '620.90', 'h'),
('P147', 'Komatsu PC650-3 Exc', '1050.00', 'h'),
('P174', 'Hazemag Crushing Plant Crusher', '0.00', 'h'),
('P177', 'MT 1440 Manitou Telehandler Forklift & Bucket', '277.20', 'h'),
('P183', 'Nirox Mobile Trommel', '840.00', 'h'),
('P198', 'Sand Wash Plant', '0.00', 'h'),
('P215', 'L/P Stacker Conveyor', '420.00', 'h'),
('P220', 'Komatsu D155A-6 Dozer', '700.00', 'h'),
('P242', 'Power Screen 624 Trommel', '840.00', 'h'),
('P243', 'Caterpillar 12H Grader', '347.90', 'h'),
('P248', 'Komatsu WA 500-6 Loader', '620.90', 'h'),
('P260', 'Komatsu PC850-8 Exc', '1365.00', 'h'),
('P285', 'Hyundai 320LC-9 Exc Fitted For GPS Complete Set', '525.00', 'h'),
('P307', 'Keestrack Screen S166', '840.00', 'h'),
('P311', 'Caterpillar 773D Watercart', '840.00', 'h'),
('P333', 'Metso LT300HP Cone Crusher 43T', '2800.00', 'h'),
('Au1', 'Auger Drive 450mm, 750mm, 2 x 2.5m Extensions', '168.00', 'h');

INSERT INTO `Products` (`ID`, `ProductName`, `ProductVal`, `Type`, `EPA`, `GroupID`, `UOM`, `AWS_CODE`) VALUES
(1, 'B TURF UNDERLAY / REC SOIL', '0', 2, 0, 15, 't', ''),
(2, 'B TURF UNDERLAY / INTERCOMPANY', '0', 2, 0, 15, 't', ''),
(5, 'B ENM', '0', 1, 0, 8, 't',  ''),
(6, 'B GSW (BUILDING & DEMO)', '0', 1, 0, 9, 't', 'B GSW (B&D)'),
(7, 'B GSW - RECYCLABLE', '0', 1, 0, 9, 't', 'B GSW -REC'),
(8, 'B13 TIMBER WASTE', '0', 1, 0, 11, 't', 'B13'),
(9, 'B12 GREEN WASTE', '0', 1, 0, 11, 't', 'GW -B12'),
(10, 'B VENM', '0', 1, 0, 8, 't', ''),
(13, 'T/Underlay screened', '0', 3, 0, 15, 't', ''),
(14, 'Garden Mix Screened', '0', 3, 0, 15, 't', ''),
(17, 'Screen Sand', '0', 4, 0, 14, 't', ''),
(18, 'Garden Mix Blended', '0', 4, 0, 15, 't', ''),
(19, 'T/Underlay Blend', '0', 4, 0, 15, 't', ''),
(31, 'Shale Cake', '0', 3, 0, 6, 't', 'KC SHALE MIX'),
(33, 'Pink Shale', '0', 4, 0, 6, 't', 'KC PISHALE'),
(34, 'Brown Shale', '0', 4, 0, 6, 't', 'KC BRSHALE'),
(35, 'Blue Shale', '0', 4, 0, 6, 't', 'KC BLSHALE'),
(36, 'DGB Roadbase', '0', 4, 0, 13, 't', 'M RDGB20'),
(40, 'Bedding Sand', '0', 2, 0, 14, 't', ''),
(61, 'Use of Hi Quality Weighbridge', '0', 2, 0, 12, 't', 'GENERAL WEIGH'),
(62, 'Scrap Metal', '0', 2, 0, 12, 't', ''),
(64, 'Concrete - Nil Charge', '0', 1, 0, 7, 't', ''),
(71, '100mm minus - Cross Over', '0', 3, 0, 10, 't', ''),
(72, 'Blended Fill Sand (WS)', '0', 3, 0, 14, 't', ''),
(73, 'Concrete Sand', '0', 3, 0, 14, 't', 'M CSND'),
(74, '40mm Crushed Sandstone', '0', 3, 0, 13, 't', ''),
(75, 'Recycled Brick-Concrete Sand', '0', 3, 0, 13, 't', ''),
(77, '6-12mm Sandstone Pebble', '0', 3, 0, 10, 't', 'M 6-112SSP'),
(78, 'White Brick Sand', '0', 3, 0, 14, 't', ''),
(79, '150-300 Gabion', '0', 3, 0, 10, 't', 'M 150-300G'),
(80, '300-500 Med', '0', 3, 0, 10, 't', ''),
(81, '500-800 Large', '0', 3, 0, 10, 't', 'M 500-800B'),
(82, 'Armour Rock 800+', '0', 3, 0, 10, 't', 'M ARMOUR'),
(84, '10-20 Crushed River Gravel', '0', 3, 0, 10, 't', ''),
(85, '20-40mm Round River Gravel', '0', 3, 0, 10, 't', ''),
(86, '40mm+ round River Gravel', '0', 3, 0, 10, 't', ''),
(87, '20mm Quartz Pebble', '0', 3, 0, 10, 't', ''),
(88, '20mm Quartz Crushed', '0', 3, 0, 10, 't', ''),
(90, 'Pre Crushed (Sand)', '0', 3, 0, 14, 't', ''),
(91, '5-7mm Sandstone Pebble', '0', 3, 0, 10, 't', ''),
(92, 'Recycled agg', '0', 3, 0, 10, 't', ''),
(95, 'Washed Sand', '0', 4, 0, 14, 't', 'M SWS'),
(96, '20mm Road Base', '0', 4, 0, 13, 't', ''),
(97, 'Raw Feed', '0', 4, 0, 14, 't', ''),
(98, 'Fine Raw Feed', '0', 4, 0, 14, 't', ''),
(99, 'Mix Brick Concrete Dirt', '0', 4, 0, 7, 't', ''),
(100, 'Concrete up to 1.5mtr', '0', 4, 0, 7, 't', ''),
(101, 'Concrete over 1.5mtr', '0', 4, 0, 7, 't', ''),
(102, 'Clean Bricks', '0', 4, 0, 7, 't', 'BRK-SM5'),
(103, 'Brick & Concrete', '0', 4, 0, 7, 't', 'BC-M6'),
(110, 'Gold Concentrate', '0', 2, 0, 12, 't', ''),
(111, '80-20 Propagating Sand', '0', 2, 0, 14, 't', ''),
(112, '3mm Sand', '0', 3, 0, 14, 't', ''),
(113, '3 - 8mm River Pebble', '0', 3, 0, 10, 't', ''),
(114, '8 - 16mm River Pebble (10-14)', '0', 3, 0, 10, 't', ''),
(115, '16 - 35mm River Pebble (20mm)', '0', 3, 0, 10, 't', ''),
(116, '35 - 50mm River Pebble', '0', 3, 0, 10, 't', ''),
(117, '50mm +  River Pebble', '0', 3, 0, 10, 't', ''),
(120, 'Pre-screened SAND Raw Feed', '0', 4, 0, 14, 't', ''),
(121, 'Pre-screened PEBBLES Raw Feed', '0', 4, 0, 10, 't', ''),
(135, 'USE OF HIQ WEIGHBRIDGE', '0', 2, 0, 12, 't', 'GENERAL WEIGH'),
(136, 'STEEL TRANSFER', '0', 2, 0, 12, 't', ''),
(139, 'S CC MED 1 NO STEEL', '0', 1, 0, 7, 't', ''),
(140, 'S CC MED 2 LIGHT MESH STEEL', '0', 1, 0, 7, 't', ''),
(141, 'S CC LRG 3 MEDIUM STEEL', '0', 1, 0, 7, 't', ''),
(142, 'S GSW general solid waste', '0', 1, 0, 7, 't', 'SM GSW-REC'),
(143, 'S BRK 5 clean bricks', '0', 1, 0, 7, 't', 'BRK-SM5'),
(144, 'S BRK 6 brick/concrete mix', '0', 1, 0, 7, 't', 'BCA-SM6'),
(145, 'S ROTAR 7 clean asphalt', '0', 1, 0, 7, 't', ''),
(146, 'S ROTAR 8 road base/asphalt mix', '0', 1, 0, 7, 't', ''),
(147, 'S SOIL/CLAY 9', '0', 1, 0, 9, 't', ''),
(148, 'S M/MASONRY 10 dirt/brick/concrete', '0', 1, 0, 7, 't', 'SM GSW(B&D)'),
(149, 'S 11 Unrecycleable waste', '0', 1, 0, 11, 't', 'UW-SM11'),
(150, 'S TIMBER/SML/12 green waste', '0', 1, 0, 11, 't', 'GW-SM12'),
(151, 'S TIMBER/LRG/13 large trunks/timber', '0', 1, 0, 11, 't', 'TW-SM13'),
(152, 'S CS/WASTE 14 dirt/brick/concrete', '0', 1, 0, 9, 't', 'SM CSPOIL 14'),
(153, 'S CW/WASTE 15 council waste', '0', 1, 0, 9, 't', 'SM CWASTE 15'),
(154, 'S VENM', '0', 1, 0, 8, 't', 'S VENM'),
(155, 'S ENM', '0', 1, 0, 8, 't', ''),
(158, 'S RAP recycled asphalt', '0', 3, 0, 13, 't', 'SM RAP'),
(159, 'S 30/70 recycled aggregate', '0', 3, 0, 10, 't', 'S 30/70 REC AGG'),
(160, 'S RSND recycled sand', '0', 3, 0, 14, 't', 'SM RSND'),
(161, 'Material Prep', '0', 3, 0, 8, 't', ''),
(162, 'S CSRS2%', '0', 3, 0, 13, 't', ''),
(163, 'S CSI', '0', 3, 0, 13, 't', ''),
(164, 'S TURF UNDERLAY', '0', 3, 0, 15, 't', 'SM TU'),
(165, 'S GARDEN MIX', '0', 3, 0, 15, 't', ''),
(166, 'S 10mm recycled aggregate ', '0', 3, 0, 10, 't', 'S 10RA'),
(167, 'S 20mm recycled aggregate', '0', 3, 0, 10, 't', 'S 20RA'),
(168, 'Fill Soil', '0', 3, 0, 15, 't', ''),
(169, '70-30 blended soil', '0', 3, 0, 15, 't', 'S 70-30BS'),
(170, 'S 20 Recycled Road Base', '0', 4, 0, 13, 't', ''),
(171, 'S RDGB20 road base RTA spec', '0', 4, 0, 13, 't', 'SM RDGB20'),
(179, '40mm Graded Rubble ', '0', 2, 0, 10, 't', ''),
(193, '20mm Class 2', '0', 2, 0, 13, 't', ''),
(194, '14/10mm Aggregrate', '0', 2, 0, 10, 't', ''),
(197, '900mm Minus Landscape Rock', '0', 2, 0, 10, 't', ''),
(198, 'Shot rock 300 minus', '0', 2, 0, 10, 't', ''),
(199, 'Cat C contaminated Soil', '0', 1, 0, 5, 't', ''),
(200, 'Cat C contaminated Soil to recycling', '0', 1, 0, 4, 't', ''),
(201, 'Cat C Contaminated Soil & Asbestos', '0', 1, 0, 3, 't', ''),
(202, 'Cat C Contaminated Soil & PCBs', '0', 1, 0, 5, 't', ''),
(203, 'Cat C Sludges / Slurries', '0', 1, 0, 5, 't', ''),
(204, 'Solid Waste with Cat C Residues', '0', 1, 0, 4, 't', ''),
(205, 'Cat C Abated Asbestos', '0', 1, 0, 3, 't', ''),
(206, 'Asbestos', '0', 1, 0, 2, 't', ''),
(207, 'Asbestos Load Rate', '0', 1, 0, 2, 't', ''),
(208, 'Cleanfill with Asbestos', '0', 1, 0, 2, 't', ''),
(209, 'Ceramic Fibres', '0', 1, 0, 12, 't', ''),
(210, 'Acid Sulfate Soils', '0', 1, 0, 1, 't', ''),
(211, 'Cleanfill  ', '0', 1, 0, 8, 't', ''),
(212, 'Cleanfill with rubble', '0', 1, 0, 8, 't', ''),
(213, 'Cleanfill with odour', '0', 1, 0, 8, 't', ''),
(214, 'Cleanfill with odour and rubble', '0', 1, 0, 8, 't', ''),
(215, 'Wet Cleanfill  ', '0', 1, 0, 8, 't', ''),
(216, 'Wet Cleanfill with rubble', '0', 1, 0, 8, 't', ''),
(217, 'Wet Cleanfill with odour', '0', 1, 0, 8, 't', ''),
(218, 'Wet Cleanfill with odour and rubble', '0', 1, 0, 8, 't', ''),
(219, 'Clean Drilling Mud', '0', 1, 0, 8, 't', ''),
(220, 'Concrete', '0', 1, 0, 7, 't', ''),
(221, 'Basalt rock', '0', 1, 0, 7, 't', ''),
(222, 'Washed Construction Sand', '0', 3, 0, 14, 't', ''),
(223, 'Packing Sand', '0', 3, 0, 14, 't', ''),
(224, 'Menage Mix', '0', 3, 0, 14, 't', ''),
(225, 'Concrete Mix', '0', 3, 0, 14, 't', ''),
(226, '7mm Washed pebble', '0', 3, 0, 10, 't', ''),
(227, '14mm Washed Pebble', '0', 3, 0, 10, 't', ''),
(228, '25mm Washed pebble', '0', 3, 0, 10, 't', ''),
(229, '5mm Dust', '0', 3, 0, 13, 't', ''),
(230, '5mm Drainage Aggregate (washed)', '0', 3, 0, 10, 't', ''),
(231, 'Washed Basalt Sand', '0', 3, 0, 14, 't', ''),
(232, '7mm aggregate', '0', 3, 0, 10, 't', ''),
(233, '14mm Aggregate', '0', 3, 0, 10, 't', ''),
(234, '20mm Aggregate', '0', 3, 0, 10, 't', ''),
(235, '20-40 mm Aggregate', '0', 3, 0, 10, 't', ''),
(237, '20mm Class4', '0', 3, 0, 13, 't', ''),
(238, '60mm NDCR', '0', 3, 0, 13, 't', ''),
(239, '100mm Graded Rubble', '0', 3, 0, 10, 't', ''),
(240, 'Spalls 40mm - 100mm', '0', 3, 0, 10, 't', ''),
(241, 'Oversize shotrock 100mm - 350mm', '0', 3, 0, 10, 't', ''),
(242, 'Clay', '0', 3, 0, 6, 't', ''),
(243, 'Topsoil organic Blend', '0', 3, 0, 15, 't', ''),
(244, '7 mm Dust', '0', 3, 0, 13, 't', ''),
(245, '20mm Class3', '0', 4, 0, 13, 't', ''),
(257, 'RELOAD', '0', 2, 0, 12, 't', ''),
(258, 'WEIGHBRIDGE ONLY', '0', 2, 0, 12, 't', ''),
(260, 'VENM - SPADEABLE', '0', 1, 0, 8, 't', 'W VENM SPADEABLE'),
(261, 'VENM', '0', 1, 0, 8, 't', 'KC VENM'),
(262, 'ENM - SPADEABLE', '0', 1, 0, 8, 't', 'W ENM SPADEABLE'),
(263, 'ENM ', '0', 1, 0, 8, 't', 'KC ENM'),
(264, 'INTERNAL ENM / VENM', '0', 1, 0, 8, 't', ''),
(265, 'GBF', '0', 3, 0, 14, 't', 'W GBF'),
(266, '100mm Crushed Sandstone', '0', 3, 0, 13, 't', ''),
(267, '75mm Crushed Sandstone', '0', 3, 0, 13, 't', 'M 75CSS'),
(268, '50mm Crushed Sandstone', '0', 3, 0, 13, 't', 'M 50CSS'),
(269, '75-150mm Sandstone Gabian', '0', 3, 0, 10, 't', 'M 75-150G'),
(270, '150-300mm Sandstone Gabian', '0', 3, 0, 10, 't', 'M 150-300G'),
(271, '300-500mm sandstone Boulder', '0', 3, 0, 10, 't', 'W 300-500B'),
(272, '500-800mm Sandstone Boulder', '0', 3, 0, 10, 't', 'W 500-800B'),
(273, '800mm+ Sandstone Armour Rock', '0', 3, 0, 10, 't', 'W ARMOUR'),
(274, 'Select Fill (Blue Shale)', '0', 3, 0, 6, 't', 'M BLSH'),
(275, 'Bulk Fill - Overburden', '0', 3, 0, 6, 't', ''),
(277, 'Ripped Sandstone to Stockpile', '0', 4, 0, 14, 't', ''),
(292, 'GSW', '0', 1, 0, 9, 't', 'WD GSW'),
(293, 'GSW C & D', '0', 1, 0, 9, 't', 'WDGSWCD'),
(294, 'Asbestos Sheet', '0', 1, 0, 2, 't', 'WD ASHT'),
(295, 'Asbestos Soil', '0', 1, 0, 2, 't', 'WD ABS'),
(296, 'Asbestos Contaminated Demo Waste', '0', 1, 0, 2, 't', 'WD ASB DEMO'),
(297, 'Glass', '0', 1, 0, 9, 't', ''),
(298, 'White Clay', '0', 3, 0, 6, 't', 'WD ASB DEMO'),
(299, 'Blue Clay', '0', 3, 0, 6, 't', '');

INSERT INTO `AWS_ADDRESS` (`ID`, `Name`, `Street`, `City`, `ZIP`, `State`) VALUES
('M', 'Menangle', 'Medhurst Road', 'MENANGLE PARK', '2563', 'NSW'),
('SM', 'St Marys', '37 Lee Holm Road', 'St Marys', '2760', 'NSW'),
('B', 'Bringelly', '761 The Northern Road', 'BRINGELLY', '2556', 'NSW'),
('W', 'Wallacia', 'Nortons Basin Road', 'WALLACIA', '2745', 'NSW'),
('WD', 'Windellama', 'Oallen Ford Road', 'GOLBOURN', '2580', 'NSW'),
('OA', 'Oallen', 'Mogo Road', 'GOLBOURN', '2580', 'NSW'),
('KC', 'Kems Creek', '1503 - 1509 Elizabeth Drive', 'KEMPS CREEK', '2178', 'NSW');

INSERT INTO `SiteList` (`ID`, `SiteName`, `SiteDesc`, `AWS_ConnectionString`, `AWS_Login`, `AWS_Password`) VALUES
(1, 'Menangle', 'Quarry', 'jdbc:interbase://192.168.16.50/c:/Program Files/Aussie weighbridge systems/Waste Management/WASTEACCOUNT.GDB', 'SYSDBA', 'smea9160TON'),
(2, 'Wallacia', 'Quarry', 'jdbc:interbase://192.168.13.50/c:/Program Files/Aussie weighbridge systems/Waste Management/WASTEACCOUNT.GDB', 'SYSDBA', 'smea9160TON');

CREATE OR REPLACE
 VIEW `Stock`
 AS SELECT 
pa.ID,
pa.ProductID,
pa.SiteID,
p.ProductName,
(SELECT coalesce(SUM(Qty),0) FROM ProductUtilization WHERE ProductAllocationID = pa.ID AND TransactionType = 3) as Production,
(SELECT coalesce(SUM(Qty),0) FROM ProductUtilization WHERE ProductAllocationID = pa.ID AND TransactionType = 4) as UsedInProduction,
(SELECT coalesce(SUM(Amount),0) FROM Sales WHERE Direction = 'IN' and SiteID = pa.siteID and ProductID = p.ID) as SalesIN,
(SELECT coalesce(SUM(Amount),0) FROM Sales WHERE Direction = 'OUT' and SiteID = pa.siteID and ProductID = p.ID) as SalesOUT
FROM Products p 
left JOIN ProductAllocation pa on pa.ProductID = p.ID
left join `ProductUtilization` pu on pa.ProductID = pu.ID
left JOIN Sales sa on pa.ProductID = sa.ProductID and pa.SiteID = sa.SiteID
GROUP BY pa.ProductID, p.ProductName, pa.SiteID, pa.ID
ORDER BY pa.ProductID DESC;