/*
Navicat SQL Server Data Transfer

Source Server         : sqlserver-2000-127.0.0.1
Source Server Version : 80000
Source Host           : 127.0.0.1:1433
Source Database       : db_spring
Source Schema         : dbo

Target Server Type    : SQL Server
Target Server Version : 80000
File Encoding         : 65001

Date: 2012-08-22 10:25:23
*/


-- ----------------------------
-- Table structure for [dbo].[t_person]
-- ----------------------------
DROP TABLE [dbo].[t_person]
GO
CREATE TABLE [dbo].[t_person] (
[ID] varchar(36) NULL ,
[birthday] datetime NULL ,
[age] int NULL ,
[userName] varchar(200) NULL ,
[gender] bit NULL 
)


GO

-- ----------------------------
-- Records of t_person
-- ----------------------------
INSERT INTO [dbo].[t_person] ([ID], [birthday], [age], [userName], [gender]) VALUES (N'2f69c7b0a3b24d33ace260e3af2501ca', N'2012-08-21 14:22:28.113', N'22', N'zhang', N'0');
GO
INSERT INTO [dbo].[t_person] ([ID], [birthday], [age], [userName], [gender]) VALUES (N'05EEA7D3-FC68-4685-912F-32ACE7D58B26', N'2012-08-22 10:24:51.803', N'22', N'zhang', N'0');
GO
INSERT INTO [dbo].[t_person] ([ID], [birthday], [age], [userName], [gender]) VALUES (N'D2321E14-2F24-4DEE-BD4B-3FE7FD7A5AFB', N'2012-08-22 10:24:52.490', N'22', N'zhang', N'0');
GO
INSERT INTO [dbo].[t_person] ([ID], [birthday], [age], [userName], [gender]) VALUES (N'E587F8DD-F0CE-455D-864A-ADBB2ED17A5F', N'2012-08-22 10:24:52.653', N'22', N'zhang', N'0');
GO
INSERT INTO [dbo].[t_person] ([ID], [birthday], [age], [userName], [gender]) VALUES (N'61B69068-1F93-493C-AFCF-740D22E97F17', N'2012-08-22 10:24:52.810', N'22', N'zhang', N'0');
GO
INSERT INTO [dbo].[t_person] ([ID], [birthday], [age], [userName], [gender]) VALUES (N'77113FF0-0027-4190-ABE7-22CB744A24B0', N'2012-08-22 10:24:52.967', N'22', N'zhang', N'0');
GO
INSERT INTO [dbo].[t_person] ([ID], [birthday], [age], [userName], [gender]) VALUES (N'7EBECF95-D2BC-482E-8930-BA63E2FDF6E3', N'2012-08-22 10:24:53.123', N'22', N'zhang', N'0');
GO
INSERT INTO [dbo].[t_person] ([ID], [birthday], [age], [userName], [gender]) VALUES (N'4B6CF4D8-41F5-4BB4-A793-C6F01ADC96FC', N'2012-08-22 10:24:53.280', N'22', N'zhang', N'0');
GO
INSERT INTO [dbo].[t_person] ([ID], [birthday], [age], [userName], [gender]) VALUES (N'ACCEE2E4-3E2A-4C1C-AD94-D1608376E981', N'2012-08-22 10:24:53.437', N'22', N'zhang', N'0');
GO
INSERT INTO [dbo].[t_person] ([ID], [birthday], [age], [userName], [gender]) VALUES (N'D67AC4EF-ABC1-40FD-BE97-3ABA3C2BD1BC', N'2012-08-22 10:24:53.577', N'22', N'zhang', N'0');
GO
INSERT INTO [dbo].[t_person] ([ID], [birthday], [age], [userName], [gender]) VALUES (N'2AD92DE7-B1C7-4AC0-A875-44A9F35A8332', N'2012-08-22 10:24:53.747', N'22', N'zhang', N'0');
GO
INSERT INTO [dbo].[t_person] ([ID], [birthday], [age], [userName], [gender]) VALUES (N'A3584114-F734-4CE7-85C3-7F5BA26906E6', N'2012-08-22 10:24:53.900', N'22', N'zhang', N'0');
GO
INSERT INTO [dbo].[t_person] ([ID], [birthday], [age], [userName], [gender]) VALUES (N'954D804A-81D2-4D79-A120-B4B72C41AD7F', N'2012-08-22 10:24:54.430', N'22', N'zhang', N'0');
GO
INSERT INTO [dbo].[t_person] ([ID], [birthday], [age], [userName], [gender]) VALUES (N'D592A643-2A1E-4045-AAB2-21E3B439C3D4', N'2012-08-22 10:24:54.200', N'22', N'zhang', N'0');
GO
INSERT INTO [dbo].[t_person] ([ID], [birthday], [age], [userName], [gender]) VALUES (N'F084E969-C8E1-4C68-B354-8B5D4BEA52E4', N'2012-08-22 10:24:54.353', N'22', N'zhang', N'0');
GO
INSERT INTO [dbo].[t_person] ([ID], [birthday], [age], [userName], [gender]) VALUES (N'F4DB4614-D6B2-45A4-B280-DF40C341731D', N'2012-08-22 10:24:54.527', N'22', N'zhang', N'0');
GO
INSERT INTO [dbo].[t_person] ([ID], [birthday], [age], [userName], [gender]) VALUES (N'46CCBC73-8505-4A6D-9F83-78EACF31C80A', N'2012-08-22 10:24:54.700', N'22', N'zhang', N'0');
GO
INSERT INTO [dbo].[t_person] ([ID], [birthday], [age], [userName], [gender]) VALUES (N'2E4AA386-355B-4E95-9D65-2F0FC9756F1C', N'2012-08-22 10:24:54.840', N'22', N'zhang', N'0');
GO
INSERT INTO [dbo].[t_person] ([ID], [birthday], [age], [userName], [gender]) VALUES (N'B3C4BEF4-C525-4D27-8A18-867EFCD41C63', N'2012-08-22 10:24:55.100', N'22', N'zhang', N'0');
GO
INSERT INTO [dbo].[t_person] ([ID], [birthday], [age], [userName], [gender]) VALUES (N'E7C7CEAB-2E33-4E61-8CEC-89EB3C9052AC', N'2012-08-22 10:24:55.167', N'22', N'zhang', N'0');
GO
INSERT INTO [dbo].[t_person] ([ID], [birthday], [age], [userName], [gender]) VALUES (N'C9457CFE-E2F5-43D3-AB71-16793614CBA6', N'2012-08-22 10:24:55.340', N'22', N'zhang', N'0');
GO
INSERT INTO [dbo].[t_person] ([ID], [birthday], [age], [userName], [gender]) VALUES (N'802588F5-106B-405C-A265-6FF2D2E6CE98', N'2012-08-22 10:24:55.493', N'22', N'zhang', N'0');
GO
INSERT INTO [dbo].[t_person] ([ID], [birthday], [age], [userName], [gender]) VALUES (N'5C002D7F-7900-46B4-8A96-ECAE111A80C5', N'2012-08-22 10:24:55.650', N'22', N'zhang', N'0');
GO
INSERT INTO [dbo].[t_person] ([ID], [birthday], [age], [userName], [gender]) VALUES (N'406E3DA6-6BC0-4C6A-8481-A47C6EB7BA2C', N'2012-08-22 10:24:55.823', N'22', N'zhang', N'0');
GO
INSERT INTO [dbo].[t_person] ([ID], [birthday], [age], [userName], [gender]) VALUES (N'DD17CF9D-FDEC-42D3-A7DF-2F8A473EF47E', N'2012-08-22 10:24:55.987', N'22', N'zhang', N'0');
GO
INSERT INTO [dbo].[t_person] ([ID], [birthday], [age], [userName], [gender]) VALUES (N'892AE8A6-67F1-4E98-9DB8-0F768E2B34BF', N'2012-08-22 10:24:56.143', N'22', N'zhang', N'0');
GO
INSERT INTO [dbo].[t_person] ([ID], [birthday], [age], [userName], [gender]) VALUES (N'A9CF252D-3DA0-4119-A73D-82AC91F388CB', N'2012-08-22 10:24:56.313', N'22', N'zhang', N'0');
GO
INSERT INTO [dbo].[t_person] ([ID], [birthday], [age], [userName], [gender]) VALUES (N'01115849-207E-46E6-B4C4-B045A4A3A678', N'2012-08-22 10:24:56.500', N'22', N'zhang', N'0');
GO
INSERT INTO [dbo].[t_person] ([ID], [birthday], [age], [userName], [gender]) VALUES (N'251A2F39-4E3C-4F3B-BE4D-D1A92D2AFF51', N'2012-08-22 10:24:56.643', N'22', N'zhang', N'0');
GO
INSERT INTO [dbo].[t_person] ([ID], [birthday], [age], [userName], [gender]) VALUES (N'2438DB84-48C4-4603-9DA2-AE06715F58ED', N'2012-08-22 10:24:56.800', N'22', N'zhang', N'0');
GO
INSERT INTO [dbo].[t_person] ([ID], [birthday], [age], [userName], [gender]) VALUES (N'009E439D-2AA9-4A99-8D28-14AA14E3CC5C', N'2012-08-22 10:24:56.957', N'22', N'zhang', N'0');
GO
INSERT INTO [dbo].[t_person] ([ID], [birthday], [age], [userName], [gender]) VALUES (N'147869BA-74F0-4A56-B30B-60CCA0E3B91D', N'2012-08-22 10:24:57.110', N'22', N'zhang', N'0');
GO
INSERT INTO [dbo].[t_person] ([ID], [birthday], [age], [userName], [gender]) VALUES (N'154CDE50-0DCE-46FB-9AFA-F176E4567ABB', N'2012-08-22 10:24:57.267', N'22', N'zhang', N'0');
GO
INSERT INTO [dbo].[t_person] ([ID], [birthday], [age], [userName], [gender]) VALUES (N'D2296A39-24EA-4D20-8ED6-52BDBB06ACF0', N'2012-08-22 10:24:57.423', N'22', N'zhang', N'0');
GO
INSERT INTO [dbo].[t_person] ([ID], [birthday], [age], [userName], [gender]) VALUES (N'6D2778AA-32B5-4899-AA9E-C673F077946A', N'2012-08-22 10:24:57.593', N'22', N'zhang', N'0');
GO
INSERT INTO [dbo].[t_person] ([ID], [birthday], [age], [userName], [gender]) VALUES (N'9FBBDBF5-D8F4-4964-8D31-314452C3EAB0', N'2012-08-22 10:24:57.750', N'22', N'zhang', N'0');
GO
INSERT INTO [dbo].[t_person] ([ID], [birthday], [age], [userName], [gender]) VALUES (N'27367936-AE60-4F69-B99F-7CF80A8E7F7F', N'2012-08-22 10:24:57.890', N'22', N'zhang', N'0');
GO
INSERT INTO [dbo].[t_person] ([ID], [birthday], [age], [userName], [gender]) VALUES (N'5CF2BE8A-D6E9-48A9-84AD-852803DD45DA', N'2012-08-22 10:24:58.630', N'22', N'zhang', N'0');
GO
INSERT INTO [dbo].[t_person] ([ID], [birthday], [age], [userName], [gender]) VALUES (N'3DD0C30F-3E80-4C73-8168-EF92AED1CEE5', N'2012-08-22 10:24:58.227', N'22', N'zhang', N'0');
GO
INSERT INTO [dbo].[t_person] ([ID], [birthday], [age], [userName], [gender]) VALUES (N'D123E152-AFF8-4876-BAA2-D5FAA78484FB', N'2012-08-22 10:24:58.367', N'22', N'zhang', N'0');
GO
INSERT INTO [dbo].[t_person] ([ID], [birthday], [age], [userName], [gender]) VALUES (N'9504439A-0B4F-4EC0-B0D8-7ED0D41FD4E2', N'2012-08-22 10:24:58.540', N'22', N'zhang', N'0');
GO
INSERT INTO [dbo].[t_person] ([ID], [birthday], [age], [userName], [gender]) VALUES (N'3D3198E9-56DE-4EB1-ACA7-22EA96622976', N'2012-08-22 10:24:58.710', N'22', N'zhang', N'0');
GO
INSERT INTO [dbo].[t_person] ([ID], [birthday], [age], [userName], [gender]) VALUES (N'B7DD680E-1DBD-4ED0-A71F-836ADF17A503', N'2012-08-22 10:24:58.900', N'22', N'zhang', N'0');
GO
INSERT INTO [dbo].[t_person] ([ID], [birthday], [age], [userName], [gender]) VALUES (N'3D7FBD48-3FE1-4F37-A7FA-E7A1EAB186CB', N'2012-08-22 10:24:59.230', N'22', N'zhang', N'0');
GO
