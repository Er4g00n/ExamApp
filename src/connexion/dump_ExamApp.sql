-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost
-- Généré le : ven. 22 jan. 2021 à 11:17
-- Version du serveur :  10.5.8-MariaDB
-- Version de PHP : 7.3.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `cyberpanel`
--
CREATE DATABASE IF NOT EXISTS `cyberpanel` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `cyberpanel`;

-- --------------------------------------------------------

--
-- Structure de la table `auth_group`
--

CREATE TABLE `auth_group` (
  `id` int(11) NOT NULL,
  `name` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `auth_group_permissions`
--

CREATE TABLE `auth_group_permissions` (
  `id` int(11) NOT NULL,
  `group_id` int(11) NOT NULL,
  `permission_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `auth_permission`
--

CREATE TABLE `auth_permission` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `content_type_id` int(11) NOT NULL,
  `codename` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `auth_permission`
--

INSERT INTO `auth_permission` (`id`, `name`, `content_type_id`, `codename`) VALUES
(1, 'Can add log entry', 1, 'add_logentry'),
(2, 'Can change log entry', 1, 'change_logentry'),
(3, 'Can delete log entry', 1, 'delete_logentry'),
(4, 'Can view log entry', 1, 'view_logentry'),
(5, 'Can add permission', 2, 'add_permission'),
(6, 'Can change permission', 2, 'change_permission'),
(7, 'Can delete permission', 2, 'delete_permission'),
(8, 'Can view permission', 2, 'view_permission'),
(9, 'Can add group', 3, 'add_group'),
(10, 'Can change group', 3, 'change_group'),
(11, 'Can delete group', 3, 'delete_group'),
(12, 'Can view group', 3, 'view_group'),
(13, 'Can add user', 4, 'add_user'),
(14, 'Can change user', 4, 'change_user'),
(15, 'Can delete user', 4, 'delete_user'),
(16, 'Can view user', 4, 'view_user'),
(17, 'Can add content type', 5, 'add_contenttype'),
(18, 'Can change content type', 5, 'change_contenttype'),
(19, 'Can delete content type', 5, 'delete_contenttype'),
(20, 'Can view content type', 5, 'view_contenttype'),
(21, 'Can add session', 6, 'add_session'),
(22, 'Can change session', 6, 'change_session'),
(23, 'Can delete session', 6, 'delete_session'),
(24, 'Can view session', 6, 'view_session'),
(25, 'Can add version', 7, 'add_version'),
(26, 'Can change version', 7, 'change_version'),
(27, 'Can delete version', 7, 'delete_version'),
(28, 'Can view version', 7, 'view_version'),
(29, 'Can add acl', 8, 'add_acl'),
(30, 'Can change acl', 8, 'change_acl'),
(31, 'Can delete acl', 8, 'delete_acl'),
(32, 'Can view acl', 8, 'view_acl'),
(33, 'Can add administrator', 9, 'add_administrator'),
(34, 'Can change administrator', 9, 'change_administrator'),
(35, 'Can delete administrator', 9, 'delete_administrator'),
(36, 'Can view administrator', 9, 'view_administrator'),
(37, 'Can add package', 10, 'add_package'),
(38, 'Can change package', 10, 'change_package'),
(39, 'Can delete package', 10, 'delete_package'),
(40, 'Can view package', 10, 'view_package'),
(41, 'Can add backup job', 11, 'add_backupjob'),
(42, 'Can change backup job', 11, 'change_backupjob'),
(43, 'Can delete backup job', 11, 'delete_backupjob'),
(44, 'Can view backup job', 11, 'view_backupjob'),
(45, 'Can add dest', 12, 'add_dest'),
(46, 'Can change dest', 12, 'change_dest'),
(47, 'Can delete dest', 12, 'delete_dest'),
(48, 'Can view dest', 12, 'view_dest'),
(49, 'Can add g drive', 13, 'add_gdrive'),
(50, 'Can change g drive', 13, 'change_gdrive'),
(51, 'Can delete g drive', 13, 'delete_gdrive'),
(52, 'Can view g drive', 13, 'view_gdrive'),
(53, 'Can add normal backup dests', 14, 'add_normalbackupdests'),
(54, 'Can change normal backup dests', 14, 'change_normalbackupdests'),
(55, 'Can delete normal backup dests', 14, 'delete_normalbackupdests'),
(56, 'Can view normal backup dests', 14, 'view_normalbackupdests'),
(57, 'Can add normal backup jobs', 15, 'add_normalbackupjobs'),
(58, 'Can change normal backup jobs', 15, 'change_normalbackupjobs'),
(59, 'Can delete normal backup jobs', 15, 'delete_normalbackupjobs'),
(60, 'Can view normal backup jobs', 15, 'view_normalbackupjobs'),
(61, 'Can add websites', 16, 'add_websites'),
(62, 'Can change websites', 16, 'change_websites'),
(63, 'Can delete websites', 16, 'delete_websites'),
(64, 'Can view websites', 16, 'view_websites'),
(65, 'Can add normal backup sites', 17, 'add_normalbackupsites'),
(66, 'Can change normal backup sites', 17, 'change_normalbackupsites'),
(67, 'Can delete normal backup sites', 17, 'delete_normalbackupsites'),
(68, 'Can view normal backup sites', 17, 'view_normalbackupsites'),
(69, 'Can add normal backup job logs', 18, 'add_normalbackupjoblogs'),
(70, 'Can change normal backup job logs', 18, 'change_normalbackupjoblogs'),
(71, 'Can delete normal backup job logs', 18, 'delete_normalbackupjoblogs'),
(72, 'Can view normal backup job logs', 18, 'view_normalbackupjoblogs'),
(73, 'Can add git logs', 19, 'add_gitlogs'),
(74, 'Can change git logs', 19, 'change_gitlogs'),
(75, 'Can delete git logs', 19, 'delete_gitlogs'),
(76, 'Can view git logs', 19, 'view_gitlogs'),
(77, 'Can add g drive sites', 20, 'add_gdrivesites'),
(78, 'Can change g drive sites', 20, 'change_gdrivesites'),
(79, 'Can delete g drive sites', 20, 'delete_gdrivesites'),
(80, 'Can view g drive sites', 20, 'view_gdrivesites'),
(81, 'Can add g drive job logs', 21, 'add_gdrivejoblogs'),
(82, 'Can change g drive job logs', 21, 'change_gdrivejoblogs'),
(83, 'Can delete g drive job logs', 21, 'delete_gdrivejoblogs'),
(84, 'Can view g drive job logs', 21, 'view_gdrivejoblogs'),
(85, 'Can add child domains', 22, 'add_childdomains'),
(86, 'Can change child domains', 22, 'change_childdomains'),
(87, 'Can delete child domains', 22, 'delete_childdomains'),
(88, 'Can view child domains', 22, 'view_childdomains'),
(89, 'Can add backup schedules', 23, 'add_backupschedules'),
(90, 'Can change backup schedules', 23, 'change_backupschedules'),
(91, 'Can delete backup schedules', 23, 'delete_backupschedules'),
(92, 'Can view backup schedules', 23, 'view_backupschedules'),
(93, 'Can add backups', 24, 'add_backups'),
(94, 'Can change backups', 24, 'change_backups'),
(95, 'Can delete backups', 24, 'delete_backups'),
(96, 'Can view backups', 24, 'view_backups'),
(97, 'Can add backup job logs', 25, 'add_backupjoblogs'),
(98, 'Can change backup job logs', 25, 'change_backupjoblogs'),
(99, 'Can delete backup job logs', 25, 'delete_backupjoblogs'),
(100, 'Can view backup job logs', 25, 'view_backupjoblogs'),
(101, 'Can add alias domains', 26, 'add_aliasdomains'),
(102, 'Can change alias domains', 26, 'change_aliasdomains'),
(103, 'Can delete alias domains', 26, 'delete_aliasdomains'),
(104, 'Can view alias domains', 26, 'view_aliasdomains'),
(105, 'Can add comments', 27, 'add_comments'),
(106, 'Can change comments', 27, 'change_comments'),
(107, 'Can delete comments', 27, 'delete_comments'),
(108, 'Can view comments', 27, 'view_comments'),
(109, 'Can add cryptokeys', 28, 'add_cryptokeys'),
(110, 'Can change cryptokeys', 28, 'change_cryptokeys'),
(111, 'Can delete cryptokeys', 28, 'delete_cryptokeys'),
(112, 'Can view cryptokeys', 28, 'view_cryptokeys'),
(113, 'Can add domainmetadata', 29, 'add_domainmetadata'),
(114, 'Can change domainmetadata', 29, 'change_domainmetadata'),
(115, 'Can delete domainmetadata', 29, 'delete_domainmetadata'),
(116, 'Can view domainmetadata', 29, 'view_domainmetadata'),
(117, 'Can add domains', 30, 'add_domains'),
(118, 'Can change domains', 30, 'change_domains'),
(119, 'Can delete domains', 30, 'delete_domains'),
(120, 'Can view domains', 30, 'view_domains'),
(121, 'Can add tsigkeys', 31, 'add_tsigkeys'),
(122, 'Can change tsigkeys', 31, 'change_tsigkeys'),
(123, 'Can delete tsigkeys', 31, 'delete_tsigkeys'),
(124, 'Can view tsigkeys', 31, 'view_tsigkeys'),
(125, 'Can add supermasters', 32, 'add_supermasters'),
(126, 'Can change supermasters', 32, 'change_supermasters'),
(127, 'Can delete supermasters', 32, 'delete_supermasters'),
(128, 'Can view supermasters', 32, 'view_supermasters'),
(129, 'Can add records', 33, 'add_records'),
(130, 'Can change records', 33, 'change_records'),
(131, 'Can delete records', 33, 'delete_records'),
(132, 'Can view records', 33, 'view_records'),
(133, 'Can add users', 34, 'add_users'),
(134, 'Can change users', 34, 'change_users'),
(135, 'Can delete users', 34, 'delete_users'),
(136, 'Can view users', 34, 'view_users'),
(137, 'Can add databases', 35, 'add_databases'),
(138, 'Can change databases', 35, 'change_databases'),
(139, 'Can delete databases', 35, 'delete_databases'),
(140, 'Can view databases', 35, 'view_databases'),
(141, 'Can add global user db', 36, 'add_globaluserdb'),
(142, 'Can change global user db', 36, 'change_globaluserdb'),
(143, 'Can delete global user db', 36, 'delete_globaluserdb'),
(144, 'Can view global user db', 36, 'view_globaluserdb'),
(145, 'Can add db meta', 37, 'add_dbmeta'),
(146, 'Can change db meta', 37, 'change_dbmeta'),
(147, 'Can delete db meta', 37, 'delete_dbmeta'),
(148, 'Can view db meta', 37, 'view_dbmeta'),
(149, 'Can add domains', 38, 'add_domains'),
(150, 'Can change domains', 38, 'change_domains'),
(151, 'Can delete domains', 38, 'delete_domains'),
(152, 'Can view domains', 38, 'view_domains'),
(153, 'Can add forwardings', 39, 'add_forwardings'),
(154, 'Can change forwardings', 39, 'change_forwardings'),
(155, 'Can delete forwardings', 39, 'delete_forwardings'),
(156, 'Can view forwardings', 39, 'view_forwardings'),
(157, 'Can add pipeprograms', 40, 'add_pipeprograms'),
(158, 'Can change pipeprograms', 40, 'change_pipeprograms'),
(159, 'Can delete pipeprograms', 40, 'delete_pipeprograms'),
(160, 'Can view pipeprograms', 40, 'view_pipeprograms'),
(161, 'Can add transport', 41, 'add_transport'),
(162, 'Can change transport', 41, 'change_transport'),
(163, 'Can delete transport', 41, 'delete_transport'),
(164, 'Can view transport', 41, 'view_transport'),
(165, 'Can add e users', 42, 'add_eusers'),
(166, 'Can change e users', 42, 'change_eusers'),
(167, 'Can delete e users', 42, 'delete_eusers'),
(168, 'Can view e users', 42, 'view_eusers'),
(169, 'Can add firewall rules', 43, 'add_firewallrules'),
(170, 'Can change firewall rules', 43, 'change_firewallrules'),
(171, 'Can delete firewall rules', 43, 'delete_firewallrules'),
(172, 'Can view firewall rules', 43, 'view_firewallrules'),
(173, 'Can add db users', 44, 'add_dbusers'),
(174, 'Can change db users', 44, 'change_dbusers'),
(175, 'Can delete db users', 44, 'delete_dbusers'),
(176, 'Can view db users', 44, 'view_dbusers'),
(177, 'Can add apache php', 45, 'add_apachephp'),
(178, 'Can change apache php', 45, 'change_apachephp'),
(179, 'Can delete apache php', 45, 'delete_apachephp'),
(180, 'Can view apache php', 45, 'view_apachephp'),
(181, 'Can add php', 46, 'add_php'),
(182, 'Can change php', 46, 'change_php'),
(183, 'Can delete php', 46, 'delete_php'),
(184, 'Can view php', 46, 'view_php'),
(185, 'Can add installed packages apache', 47, 'add_installedpackagesapache'),
(186, 'Can change installed packages apache', 47, 'change_installedpackagesapache'),
(187, 'Can delete installed packages apache', 47, 'delete_installedpackagesapache'),
(188, 'Can view installed packages apache', 47, 'view_installedpackagesapache'),
(189, 'Can add installed packages', 48, 'add_installedpackages'),
(190, 'Can change installed packages', 48, 'change_installedpackages'),
(191, 'Can delete installed packages', 48, 'delete_installedpackages'),
(192, 'Can view installed packages', 48, 'view_installedpackages'),
(193, 'Can add trash', 49, 'add_trash'),
(194, 'Can change trash', 49, 'change_trash'),
(195, 'Can delete trash', 49, 'delete_trash'),
(196, 'Can view trash', 49, 'view_trash'),
(197, 'Can add pdns status', 50, 'add_pdnsstatus'),
(198, 'Can change pdns status', 50, 'change_pdnsstatus'),
(199, 'Can delete pdns status', 50, 'delete_pdnsstatus'),
(200, 'Can view pdns status', 50, 'view_pdnsstatus'),
(201, 'Can add slave servers', 51, 'add_slaveservers'),
(202, 'Can change slave servers', 51, 'change_slaveservers'),
(203, 'Can delete slave servers', 51, 'delete_slaveservers'),
(204, 'Can view slave servers', 51, 'view_slaveservers'),
(205, 'Can add email logs', 52, 'add_emaillogs'),
(206, 'Can change email logs', 52, 'change_emaillogs'),
(207, 'Can delete email logs', 52, 'delete_emaillogs'),
(208, 'Can view email logs', 52, 'view_emaillogs'),
(209, 'Can add email limits', 53, 'add_emaillimits'),
(210, 'Can change email limits', 53, 'change_emaillimits'),
(211, 'Can delete email limits', 53, 'delete_emaillimits'),
(212, 'Can view email limits', 53, 'view_emaillimits'),
(213, 'Can add domain limits', 54, 'add_domainlimits'),
(214, 'Can change domain limits', 54, 'change_domainlimits'),
(215, 'Can delete domain limits', 54, 'delete_domainlimits'),
(216, 'Can view domain limits', 54, 'view_domainlimits'),
(217, 'Can add email lists', 55, 'add_emaillists'),
(218, 'Can change email lists', 55, 'change_emaillists'),
(219, 'Can delete email lists', 55, 'delete_emaillists'),
(220, 'Can view email lists', 55, 'view_emaillists'),
(221, 'Can add email marketing', 56, 'add_emailmarketing'),
(222, 'Can change email marketing', 56, 'change_emailmarketing'),
(223, 'Can delete email marketing', 56, 'delete_emailmarketing'),
(224, 'Can view email marketing', 56, 'view_emailmarketing'),
(225, 'Can add validation log', 57, 'add_validationlog'),
(226, 'Can change validation log', 57, 'change_validationlog'),
(227, 'Can delete validation log', 57, 'delete_validationlog'),
(228, 'Can view validation log', 57, 'view_validationlog'),
(229, 'Can add smtp hosts', 58, 'add_smtphosts'),
(230, 'Can change smtp hosts', 58, 'change_smtphosts'),
(231, 'Can delete smtp hosts', 58, 'delete_smtphosts'),
(232, 'Can view smtp hosts', 58, 'view_smtphosts'),
(233, 'Can add email template', 59, 'add_emailtemplate'),
(234, 'Can change email template', 59, 'change_emailtemplate'),
(235, 'Can delete email template', 59, 'delete_emailtemplate'),
(236, 'Can view email template', 59, 'view_emailtemplate'),
(237, 'Can add emails in list', 60, 'add_emailsinlist'),
(238, 'Can change emails in list', 60, 'change_emailsinlist'),
(239, 'Can delete emails in list', 60, 'delete_emailsinlist'),
(240, 'Can view emails in list', 60, 'view_emailsinlist'),
(241, 'Can add email jobs', 61, 'add_emailjobs'),
(242, 'Can change email jobs', 61, 'change_emailjobs'),
(243, 'Can delete email jobs', 61, 'delete_emailjobs'),
(244, 'Can view email jobs', 61, 'view_emailjobs'),
(245, 'Can add backup plan', 62, 'add_backupplan'),
(246, 'Can change backup plan', 62, 'change_backupplan'),
(247, 'Can delete backup plan', 62, 'delete_backupplan'),
(248, 'Can view backup plan', 62, 'view_backupplan'),
(249, 'Can add backup plan do', 63, 'add_backupplando'),
(250, 'Can change backup plan do', 63, 'change_backupplando'),
(251, 'Can delete backup plan do', 63, 'delete_backupplando'),
(252, 'Can view backup plan do', 63, 'view_backupplando'),
(253, 'Can add backup plan minio', 64, 'add_backupplanminio'),
(254, 'Can change backup plan minio', 64, 'change_backupplanminio'),
(255, 'Can delete backup plan minio', 64, 'delete_backupplanminio'),
(256, 'Can view backup plan minio', 64, 'view_backupplanminio'),
(257, 'Can add websites in plan minio', 65, 'add_websitesinplanminio'),
(258, 'Can change websites in plan minio', 65, 'change_websitesinplanminio'),
(259, 'Can delete websites in plan minio', 65, 'delete_websitesinplanminio'),
(260, 'Can view websites in plan minio', 65, 'view_websitesinplanminio'),
(261, 'Can add websites in plan do', 66, 'add_websitesinplando'),
(262, 'Can change websites in plan do', 66, 'change_websitesinplando'),
(263, 'Can delete websites in plan do', 66, 'delete_websitesinplando'),
(264, 'Can view websites in plan do', 66, 'view_websitesinplando'),
(265, 'Can add websites in plan', 67, 'add_websitesinplan'),
(266, 'Can change websites in plan', 67, 'change_websitesinplan'),
(267, 'Can delete websites in plan', 67, 'delete_websitesinplan'),
(268, 'Can view websites in plan', 67, 'view_websitesinplan'),
(269, 'Can add minio nodes', 68, 'add_minionodes'),
(270, 'Can change minio nodes', 68, 'change_minionodes'),
(271, 'Can delete minio nodes', 68, 'delete_minionodes'),
(272, 'Can view minio nodes', 68, 'view_minionodes'),
(273, 'Can add backup logs minio', 69, 'add_backuplogsminio'),
(274, 'Can change backup logs minio', 69, 'change_backuplogsminio'),
(275, 'Can delete backup logs minio', 69, 'delete_backuplogsminio'),
(276, 'Can view backup logs minio', 69, 'view_backuplogsminio'),
(277, 'Can add backup logs do', 70, 'add_backuplogsdo'),
(278, 'Can change backup logs do', 70, 'change_backuplogsdo'),
(279, 'Can delete backup logs do', 70, 'delete_backuplogsdo'),
(280, 'Can view backup logs do', 70, 'view_backuplogsdo'),
(281, 'Can add backup logs', 71, 'add_backuplogs'),
(282, 'Can change backup logs', 71, 'change_backuplogs'),
(283, 'Can delete backup logs', 71, 'delete_backuplogs'),
(284, 'Can view backup logs', 71, 'view_backuplogs'),
(285, 'Can add containers', 72, 'add_containers'),
(286, 'Can change containers', 72, 'change_containers'),
(287, 'Can delete containers', 72, 'delete_containers'),
(288, 'Can view containers', 72, 'view_containers'),
(289, 'Can add container limits', 73, 'add_containerlimits'),
(290, 'Can change container limits', 73, 'change_containerlimits'),
(291, 'Can delete container limits', 73, 'delete_containerlimits'),
(292, 'Can view container limits', 73, 'view_containerlimits'),
(293, 'Can add cl packages', 74, 'add_clpackages'),
(294, 'Can change cl packages', 74, 'change_clpackages'),
(295, 'Can delete cl packages', 74, 'delete_clpackages'),
(296, 'Can view cl packages', 74, 'view_clpackages'),
(297, 'Can add backup job', 75, 'add_backupjob'),
(298, 'Can change backup job', 75, 'change_backupjob'),
(299, 'Can delete backup job', 75, 'delete_backupjob'),
(300, 'Can view backup job', 75, 'view_backupjob'),
(301, 'Can add inc job', 76, 'add_incjob'),
(302, 'Can change inc job', 76, 'change_incjob'),
(303, 'Can delete inc job', 76, 'delete_incjob'),
(304, 'Can view inc job', 76, 'view_incjob'),
(305, 'Can add job snapshots', 77, 'add_jobsnapshots'),
(306, 'Can change job snapshots', 77, 'change_jobsnapshots'),
(307, 'Can delete job snapshots', 77, 'delete_jobsnapshots'),
(308, 'Can view job snapshots', 77, 'view_jobsnapshots'),
(309, 'Can add job sites', 78, 'add_jobsites'),
(310, 'Can change job sites', 78, 'change_jobsites'),
(311, 'Can delete job sites', 78, 'delete_jobsites'),
(312, 'Can view job sites', 78, 'view_jobsites');

-- --------------------------------------------------------

--
-- Structure de la table `auth_user`
--

CREATE TABLE `auth_user` (
  `id` int(11) NOT NULL,
  `password` varchar(128) NOT NULL,
  `last_login` datetime(6) DEFAULT NULL,
  `is_superuser` tinyint(1) NOT NULL,
  `username` varchar(150) NOT NULL,
  `first_name` varchar(150) NOT NULL,
  `last_name` varchar(150) NOT NULL,
  `email` varchar(254) NOT NULL,
  `is_staff` tinyint(1) NOT NULL,
  `is_active` tinyint(1) NOT NULL,
  `date_joined` datetime(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `auth_user_groups`
--

CREATE TABLE `auth_user_groups` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `group_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `auth_user_user_permissions`
--

CREATE TABLE `auth_user_user_permissions` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `permission_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `baseTemplate_version`
--

CREATE TABLE `baseTemplate_version` (
  `id` int(11) NOT NULL,
  `currentVersion` varchar(50) NOT NULL,
  `build` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `baseTemplate_version`
--

INSERT INTO `baseTemplate_version` (`id`, `currentVersion`, `build`) VALUES
(1, '2.0', 3);

-- --------------------------------------------------------

--
-- Structure de la table `CLManager_clpackages`
--

CREATE TABLE `CLManager_clpackages` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `speed` varchar(50) NOT NULL,
  `vmem` varchar(50) NOT NULL,
  `pmem` varchar(50) NOT NULL,
  `io` varchar(50) NOT NULL,
  `iops` varchar(50) NOT NULL,
  `ep` varchar(50) NOT NULL,
  `nproc` varchar(50) NOT NULL,
  `inodessoft` varchar(50) NOT NULL,
  `inodeshard` varchar(50) NOT NULL,
  `owner_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `comments`
--

CREATE TABLE `comments` (
  `id` int(11) NOT NULL,
  `domain_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `type` varchar(10) NOT NULL,
  `modified_at` int(11) NOT NULL,
  `account` varchar(40) NOT NULL,
  `comment` longtext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `containerization_containerlimits`
--

CREATE TABLE `containerization_containerlimits` (
  `id` int(11) NOT NULL,
  `cpuPers` varchar(10) NOT NULL,
  `IO` varchar(10) NOT NULL,
  `IOPS` varchar(10) NOT NULL,
  `memory` varchar(10) NOT NULL,
  `networkSpeed` varchar(10) NOT NULL,
  `networkHexValue` varchar(10) NOT NULL,
  `enforce` int(11) NOT NULL,
  `owner_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `cryptokeys`
--

CREATE TABLE `cryptokeys` (
  `id` int(11) NOT NULL,
  `domain_id` int(11) NOT NULL,
  `flags` int(11) NOT NULL,
  `active` int(11) DEFAULT NULL,
  `content` longtext DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `databases_databases`
--

CREATE TABLE `databases_databases` (
  `id` int(11) NOT NULL,
  `dbName` varchar(50) NOT NULL,
  `dbUser` varchar(50) NOT NULL,
  `website_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `databases_databases`
--

INSERT INTO `databases_databases` (`id`, `dbName`, `dbUser`, `website_id`) VALUES
(1, 'er4g_ExamApp', 'er4g_DevExamApp', 1);

-- --------------------------------------------------------

--
-- Structure de la table `databases_dbmeta`
--

CREATE TABLE `databases_dbmeta` (
  `id` int(11) NOT NULL,
  `key` varchar(200) NOT NULL,
  `value` longtext NOT NULL,
  `database_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `databases_globaluserdb`
--

CREATE TABLE `databases_globaluserdb` (
  `id` int(11) NOT NULL,
  `username` varchar(200) NOT NULL,
  `password` varchar(500) NOT NULL,
  `token` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `databases_globaluserdb`
--

INSERT INTO `databases_globaluserdb` (`id`, `username`, `password`, `token`) VALUES
(9, 'admin', 'S3z8H7MYb3GfnQ', 'fhyXTVONZsQfH3');

-- --------------------------------------------------------

--
-- Structure de la table `django_admin_log`
--

CREATE TABLE `django_admin_log` (
  `id` int(11) NOT NULL,
  `action_time` datetime(6) NOT NULL,
  `object_id` longtext DEFAULT NULL,
  `object_repr` varchar(200) NOT NULL,
  `action_flag` smallint(5) UNSIGNED NOT NULL CHECK (`action_flag` >= 0),
  `change_message` longtext NOT NULL,
  `content_type_id` int(11) DEFAULT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `django_content_type`
--

CREATE TABLE `django_content_type` (
  `id` int(11) NOT NULL,
  `app_label` varchar(100) NOT NULL,
  `model` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `django_content_type`
--

INSERT INTO `django_content_type` (`id`, `app_label`, `model`) VALUES
(1, 'admin', 'logentry'),
(3, 'auth', 'group'),
(2, 'auth', 'permission'),
(4, 'auth', 'user'),
(44, 'backup', 'dbusers'),
(7, 'baseTemplate', 'version'),
(74, 'CLManager', 'clpackages'),
(73, 'containerization', 'containerlimits'),
(5, 'contenttypes', 'contenttype'),
(35, 'databases', 'databases'),
(37, 'databases', 'dbmeta'),
(36, 'databases', 'globaluserdb'),
(27, 'dns', 'comments'),
(28, 'dns', 'cryptokeys'),
(29, 'dns', 'domainmetadata'),
(30, 'dns', 'domains'),
(33, 'dns', 'records'),
(32, 'dns', 'supermasters'),
(31, 'dns', 'tsigkeys'),
(72, 'dockerManager', 'containers'),
(61, 'emailMarketing', 'emailjobs'),
(55, 'emailMarketing', 'emaillists'),
(56, 'emailMarketing', 'emailmarketing'),
(60, 'emailMarketing', 'emailsinlist'),
(59, 'emailMarketing', 'emailtemplate'),
(58, 'emailMarketing', 'smtphosts'),
(57, 'emailMarketing', 'validationlog'),
(54, 'emailPremium', 'domainlimits'),
(53, 'emailPremium', 'emaillimits'),
(52, 'emailPremium', 'emaillogs'),
(49, 'filemanager', 'trash'),
(43, 'firewall', 'firewallrules'),
(34, 'ftp', 'users'),
(75, 'IncBackups', 'backupjob'),
(76, 'IncBackups', 'incjob'),
(78, 'IncBackups', 'jobsites'),
(77, 'IncBackups', 'jobsnapshots'),
(8, 'loginSystem', 'acl'),
(9, 'loginSystem', 'administrator'),
(38, 'mailServer', 'domains'),
(42, 'mailServer', 'eusers'),
(39, 'mailServer', 'forwardings'),
(40, 'mailServer', 'pipeprograms'),
(41, 'mailServer', 'transport'),
(45, 'managePHP', 'apachephp'),
(48, 'managePHP', 'installedpackages'),
(47, 'managePHP', 'installedpackagesapache'),
(46, 'managePHP', 'php'),
(50, 'manageServices', 'pdnsstatus'),
(51, 'manageServices', 'slaveservers'),
(10, 'packages', 'package'),
(71, 's3Backups', 'backuplogs'),
(70, 's3Backups', 'backuplogsdo'),
(69, 's3Backups', 'backuplogsminio'),
(62, 's3Backups', 'backupplan'),
(63, 's3Backups', 'backupplando'),
(64, 's3Backups', 'backupplanminio'),
(68, 's3Backups', 'minionodes'),
(67, 's3Backups', 'websitesinplan'),
(66, 's3Backups', 'websitesinplando'),
(65, 's3Backups', 'websitesinplanminio'),
(6, 'sessions', 'session'),
(26, 'websiteFunctions', 'aliasdomains'),
(11, 'websiteFunctions', 'backupjob'),
(25, 'websiteFunctions', 'backupjoblogs'),
(24, 'websiteFunctions', 'backups'),
(23, 'websiteFunctions', 'backupschedules'),
(22, 'websiteFunctions', 'childdomains'),
(12, 'websiteFunctions', 'dest'),
(13, 'websiteFunctions', 'gdrive'),
(21, 'websiteFunctions', 'gdrivejoblogs'),
(20, 'websiteFunctions', 'gdrivesites'),
(19, 'websiteFunctions', 'gitlogs'),
(14, 'websiteFunctions', 'normalbackupdests'),
(18, 'websiteFunctions', 'normalbackupjoblogs'),
(15, 'websiteFunctions', 'normalbackupjobs'),
(17, 'websiteFunctions', 'normalbackupsites'),
(16, 'websiteFunctions', 'websites');

-- --------------------------------------------------------

--
-- Structure de la table `django_migrations`
--

CREATE TABLE `django_migrations` (
  `id` int(11) NOT NULL,
  `app` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `applied` datetime(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `django_migrations`
--

INSERT INTO `django_migrations` (`id`, `app`, `name`, `applied`) VALUES
(1, 'loginSystem', '0001_initial', '2021-01-12 08:10:20.510599'),
(2, 'packages', '0001_initial', '2021-01-12 08:10:20.547355'),
(3, 'CLManager', '0001_initial', '2021-01-12 08:10:20.576964'),
(4, 'websiteFunctions', '0001_initial', '2021-01-12 08:10:20.852693'),
(5, 'IncBackups', '0001_initial', '2021-01-12 08:10:21.104564'),
(6, 'contenttypes', '0001_initial', '2021-01-12 08:10:21.151268'),
(7, 'auth', '0001_initial', '2021-01-12 08:10:21.203844'),
(8, 'admin', '0001_initial', '2021-01-12 08:10:21.331878'),
(9, 'admin', '0002_logentry_remove_auto_add', '2021-01-12 08:10:21.374262'),
(10, 'admin', '0003_logentry_add_action_flag_choices', '2021-01-12 08:10:21.389690'),
(11, 'contenttypes', '0002_remove_content_type_name', '2021-01-12 08:10:21.462419'),
(12, 'auth', '0002_alter_permission_name_max_length', '2021-01-12 08:10:21.475889'),
(13, 'auth', '0003_alter_user_email_max_length', '2021-01-12 08:10:21.490908'),
(14, 'auth', '0004_alter_user_username_opts', '2021-01-12 08:10:21.503122'),
(15, 'auth', '0005_alter_user_last_login_null', '2021-01-12 08:10:21.526018'),
(16, 'auth', '0006_require_contenttypes_0002', '2021-01-12 08:10:21.528612'),
(17, 'auth', '0007_alter_validators_add_error_messages', '2021-01-12 08:10:21.539992'),
(18, 'auth', '0008_alter_user_username_max_length', '2021-01-12 08:10:21.553689'),
(19, 'auth', '0009_alter_user_last_name_max_length', '2021-01-12 08:10:21.565910'),
(20, 'auth', '0010_alter_group_name_max_length', '2021-01-12 08:10:21.581677'),
(21, 'auth', '0011_update_proxy_permissions', '2021-01-12 08:10:21.612917'),
(22, 'auth', '0012_alter_user_first_name_max_length', '2021-01-12 08:10:21.683694'),
(23, 'backup', '0001_initial', '2021-01-12 08:10:21.690155'),
(24, 'baseTemplate', '0001_initial', '2021-01-12 08:10:21.699856'),
(25, 'containerization', '0001_initial', '2021-01-12 08:10:21.730801'),
(26, 'databases', '0001_initial', '2021-01-12 08:10:21.821666'),
(27, 'dns', '0001_initial', '2021-01-12 08:10:21.960715'),
(28, 'dockerManager', '0001_initial', '2021-01-12 08:10:22.031229'),
(29, 'emailMarketing', '0001_initial', '2021-01-12 08:10:22.282729'),
(30, 'mailServer', '0001_initial', '2021-01-12 08:10:22.458110'),
(31, 'emailPremium', '0001_initial', '2021-01-12 08:10:22.637941'),
(32, 'filemanager', '0001_initial', '2021-01-12 08:10:22.727482'),
(33, 'firewall', '0001_initial', '2021-01-12 08:10:22.752667'),
(34, 'ftp', '0001_initial', '2021-01-12 08:10:22.804348'),
(35, 'managePHP', '0001_initial', '2021-01-12 08:10:22.860621'),
(36, 'manageServices', '0001_initial', '2021-01-12 08:10:22.908042'),
(37, 's3Backups', '0001_initial', '2021-01-12 08:10:23.595842'),
(38, 'sessions', '0001_initial', '2021-01-12 08:10:23.725620');

-- --------------------------------------------------------

--
-- Structure de la table `django_session`
--

CREATE TABLE `django_session` (
  `session_key` varchar(40) NOT NULL,
  `session_data` longtext NOT NULL,
  `expire_date` datetime(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `django_session`
--

INSERT INTO `django_session` (`session_key`, `session_data`, `expire_date`) VALUES
('e8w4l452mgb6mqxn9nsqhgme73qnfxzy', 'eyJ1c2VySUQiOjEsImlwQWRkciI6IjkxLjE2NS42Ni41NiIsIl9zZXNzaW9uX2V4cGlyeSI6NDMyMDB9:1l1xHL:QuWi6MuLe6XAF-WI5vKZGBYaJ7ZaqZaizyutJGqugpU', '2021-01-20 08:07:03.604692'),
('fg2286ymdft18y5r3scr6e2jymdqdf06', 'eyJ1c2VySUQiOjEsImlwQWRkciI6IjkxLjE2NS42Ni41NiIsIl9zZXNzaW9uX2V4cGlyeSI6NDMyMDB9:1l1laV:lZyc1i_Jp_3m3ta9htvCthbx5BHqsdCu8y7AQTVCRF4', '2021-01-19 19:38:03.670241'),
('gk163asb4scplr3jkesjbav71u0ls3y4', 'eyJ1c2VySUQiOjEsImlwQWRkciI6IjkxLjE2NS42Ni41NiIsIl9zZXNzaW9uX2V4cGlyeSI6NDMyMDB9:1l2c4W:zA5lpxzXwyIkSCNJCHcrjT-5GDOqGN6_WkCS-IrYH3s', '2021-01-22 03:40:32.319673'),
('vvkndppupjrggrj5ctaxl5qqtl2a6n5t', 'eyJ1c2VySUQiOjEsImlwQWRkciI6IjkxLjE2NS42Ni41NiIsIl9zZXNzaW9uX2V4cGlyeSI6NDMyMDB9:1kzqlT:atYbVGKWRIeBCP1Tuj0Ff4Bm4CW8ZcpGgEMDshT5OII', '2021-01-14 12:45:27.229230'),
('yhz715nunnl0nlydl077ix4qypjqgqbs', 'eyJ1c2VySUQiOjEsImlwQWRkciI6IjkxLjE2NS42Ni41NiIsIl9zZXNzaW9uX2V4cGlyeSI6NDMyMDB9:1l2uQs:4BKl9zJyEuHjBUSjw6FA_-NmB32IMTiqpvun8a2G-8w', '2021-01-22 23:16:50.454320');

-- --------------------------------------------------------

--
-- Structure de la table `dockerManager_containers`
--

CREATE TABLE `dockerManager_containers` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `cid` varchar(64) NOT NULL,
  `image` varchar(50) NOT NULL,
  `tag` varchar(50) NOT NULL,
  `memory` int(11) NOT NULL,
  `ports` longtext NOT NULL,
  `volumes` longtext NOT NULL,
  `env` longtext NOT NULL,
  `startOnReboot` int(11) NOT NULL,
  `admin_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `domainmetadata`
--

CREATE TABLE `domainmetadata` (
  `id` int(11) NOT NULL,
  `domain_id` int(11) NOT NULL,
  `kind` varchar(32) DEFAULT NULL,
  `content` longtext DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `domains`
--

CREATE TABLE `domains` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `master` varchar(128) DEFAULT NULL,
  `last_check` int(11) DEFAULT NULL,
  `type` varchar(6) NOT NULL,
  `notified_serial` int(11) DEFAULT NULL,
  `account` varchar(40) DEFAULT NULL,
  `admin_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `domains`
--

INSERT INTO `domains` (`id`, `name`, `master`, `last_check`, `type`, `notified_serial`, `account`, `admin_id`) VALUES
(1, 'er4goon.com', NULL, NULL, 'NATIVE', NULL, NULL, 1);

-- --------------------------------------------------------

--
-- Structure de la table `emailMarketing_emailjobs`
--

CREATE TABLE `emailMarketing_emailjobs` (
  `id` int(11) NOT NULL,
  `date` varchar(200) NOT NULL,
  `host` varchar(1000) NOT NULL,
  `totalEmails` int(11) NOT NULL,
  `sent` int(11) NOT NULL,
  `failed` int(11) NOT NULL,
  `owner_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `emailMarketing_emaillists`
--

CREATE TABLE `emailMarketing_emaillists` (
  `id` int(11) NOT NULL,
  `listName` varchar(50) NOT NULL,
  `dateCreated` varchar(200) NOT NULL,
  `verified` int(11) NOT NULL,
  `notVerified` int(11) NOT NULL,
  `owner_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `emailMarketing_emailmarketing`
--

CREATE TABLE `emailMarketing_emailmarketing` (
  `id` int(11) NOT NULL,
  `userName` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `emailMarketing_emailsinlist`
--

CREATE TABLE `emailMarketing_emailsinlist` (
  `id` int(11) NOT NULL,
  `email` varchar(50) NOT NULL,
  `firstName` varchar(20) NOT NULL,
  `lastName` varchar(20) NOT NULL,
  `verificationStatus` varchar(100) NOT NULL,
  `dateCreated` varchar(200) NOT NULL,
  `owner_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `emailMarketing_emailtemplate`
--

CREATE TABLE `emailMarketing_emailtemplate` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `subject` varchar(1000) NOT NULL,
  `fromName` varchar(100) NOT NULL,
  `fromEmail` varchar(150) NOT NULL,
  `replyTo` varchar(150) NOT NULL,
  `emailMessage` longtext NOT NULL,
  `owner_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `emailMarketing_smtphosts`
--

CREATE TABLE `emailMarketing_smtphosts` (
  `id` int(11) NOT NULL,
  `host` varchar(150) NOT NULL,
  `port` varchar(10) NOT NULL,
  `userName` varchar(200) NOT NULL,
  `password` varchar(200) NOT NULL,
  `owner_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `emailMarketing_validationlog`
--

CREATE TABLE `emailMarketing_validationlog` (
  `id` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  `message` longtext NOT NULL,
  `owner_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `emailPremium_domainlimits`
--

CREATE TABLE `emailPremium_domainlimits` (
  `id` int(11) NOT NULL,
  `limitStatus` int(11) NOT NULL,
  `monthlyLimit` int(11) NOT NULL,
  `monthlyUsed` int(11) NOT NULL,
  `domain_id` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `emailPremium_emaillimits`
--

CREATE TABLE `emailPremium_emaillimits` (
  `id` int(11) NOT NULL,
  `limitStatus` int(11) NOT NULL,
  `monthlyLimits` int(11) NOT NULL,
  `monthlyUsed` int(11) NOT NULL,
  `hourlyLimit` int(11) NOT NULL,
  `hourlyUsed` int(11) NOT NULL,
  `emailLogs` int(11) NOT NULL,
  `email_id` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `emailPremium_emaillogs`
--

CREATE TABLE `emailPremium_emaillogs` (
  `id` int(11) NOT NULL,
  `destination` varchar(200) NOT NULL,
  `timeStamp` varchar(200) NOT NULL,
  `email_id` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `e_domains`
--

CREATE TABLE `e_domains` (
  `domain` varchar(50) NOT NULL,
  `childOwner_id` int(11) DEFAULT NULL,
  `domainOwner_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `e_forwardings`
--

CREATE TABLE `e_forwardings` (
  `id` int(11) NOT NULL,
  `source` varchar(80) NOT NULL,
  `destination` longtext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `e_transport`
--

CREATE TABLE `e_transport` (
  `id` int(11) NOT NULL,
  `domain` varchar(128) NOT NULL,
  `transport` varchar(128) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `e_users`
--

CREATE TABLE `e_users` (
  `email` varchar(80) NOT NULL,
  `password` varchar(200) NOT NULL,
  `mail` varchar(200) NOT NULL,
  `emailOwner_id` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `filemanager_trash`
--

CREATE TABLE `filemanager_trash` (
  `id` int(11) NOT NULL,
  `originalPath` varchar(500) NOT NULL,
  `fileName` varchar(200) NOT NULL,
  `website_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `firewall_firewallrules`
--

CREATE TABLE `firewall_firewallrules` (
  `id` int(11) NOT NULL,
  `name` varchar(32) NOT NULL,
  `proto` varchar(10) NOT NULL,
  `port` varchar(25) NOT NULL,
  `ipAddress` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `firewall_firewallrules`
--

INSERT INTO `firewall_firewallrules` (`id`, `name`, `proto`, `port`, `ipAddress`) VALUES
(1, 'panel', 'tcp', '8090', '0.0.0.0/0'),
(2, 'http', 'tcp', '80', '0.0.0.0/0'),
(3, 'https', 'tcp', '443', '0.0.0.0/0'),
(4, 'ftp', 'tcp', '21', '0.0.0.0/0'),
(5, 'smtp', 'tcp', '25', '0.0.0.0/0'),
(6, 'smtps', 'tcp', '587', '0.0.0.0/0'),
(7, 'ssmtp', 'tcp', '465', '0.0.0.0/0'),
(8, 'pop3', 'tcp', '110', '0.0.0.0/0'),
(9, 'imap', 'tcp', '143', '0.0.0.0/0'),
(10, 'simap', 'tcp', '993', '0.0.0.0/0'),
(11, 'dns', 'udp', '53', '0.0.0.0/0'),
(12, 'dnstcp', 'tcp', '53', '0.0.0.0/0'),
(13, 'ftptls', 'tcp', '40110-40210', '0.0.0.0/0'),
(14, 'POP3S', 'tcp', '995', '0.0.0.0/0'),
(15, 'quic', 'udp', '443', '0.0.0.0/0');

-- --------------------------------------------------------

--
-- Structure de la table `IncBackups_backupjob`
--

CREATE TABLE `IncBackups_backupjob` (
  `id` int(11) NOT NULL,
  `destination` varchar(300) NOT NULL,
  `frequency` varchar(50) NOT NULL,
  `websiteData` int(11) NOT NULL,
  `websiteDatabases` int(11) NOT NULL,
  `websiteDataEmails` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `IncBackups_incjob`
--

CREATE TABLE `IncBackups_incjob` (
  `id` int(11) NOT NULL,
  `date` datetime(6) NOT NULL,
  `website_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `IncBackups_jobsites`
--

CREATE TABLE `IncBackups_jobsites` (
  `id` int(11) NOT NULL,
  `website` varchar(300) NOT NULL,
  `job_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `IncBackups_jobsnapshots`
--

CREATE TABLE `IncBackups_jobsnapshots` (
  `id` int(11) NOT NULL,
  `type` varchar(300) NOT NULL,
  `snapshotid` varchar(50) NOT NULL,
  `destination` varchar(200) NOT NULL,
  `job_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `loginSystem_acl`
--

CREATE TABLE `loginSystem_acl` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `adminStatus` int(11) NOT NULL,
  `versionManagement` int(11) NOT NULL,
  `createNewUser` int(11) NOT NULL,
  `listUsers` int(11) NOT NULL,
  `deleteUser` int(11) NOT NULL,
  `resellerCenter` int(11) NOT NULL,
  `changeUserACL` int(11) NOT NULL,
  `createWebsite` int(11) NOT NULL,
  `modifyWebsite` int(11) NOT NULL,
  `suspendWebsite` int(11) NOT NULL,
  `deleteWebsite` int(11) NOT NULL,
  `createPackage` int(11) NOT NULL,
  `listPackages` int(11) NOT NULL,
  `deletePackage` int(11) NOT NULL,
  `modifyPackage` int(11) NOT NULL,
  `createDatabase` int(11) NOT NULL,
  `deleteDatabase` int(11) NOT NULL,
  `listDatabases` int(11) NOT NULL,
  `createNameServer` int(11) NOT NULL,
  `createDNSZone` int(11) NOT NULL,
  `deleteZone` int(11) NOT NULL,
  `addDeleteRecords` int(11) NOT NULL,
  `createEmail` int(11) NOT NULL,
  `listEmails` int(11) NOT NULL,
  `deleteEmail` int(11) NOT NULL,
  `emailForwarding` int(11) NOT NULL,
  `changeEmailPassword` int(11) NOT NULL,
  `dkimManager` int(11) NOT NULL,
  `createFTPAccount` int(11) NOT NULL,
  `deleteFTPAccount` int(11) NOT NULL,
  `listFTPAccounts` int(11) NOT NULL,
  `createBackup` int(11) NOT NULL,
  `restoreBackup` int(11) NOT NULL,
  `addDeleteDestinations` int(11) NOT NULL,
  `scheDuleBackups` int(11) NOT NULL,
  `remoteBackups` int(11) NOT NULL,
  `manageSSL` int(11) NOT NULL,
  `hostnameSSL` int(11) NOT NULL,
  `mailServerSSL` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `loginSystem_acl`
--

INSERT INTO `loginSystem_acl` (`id`, `name`, `adminStatus`, `versionManagement`, `createNewUser`, `listUsers`, `deleteUser`, `resellerCenter`, `changeUserACL`, `createWebsite`, `modifyWebsite`, `suspendWebsite`, `deleteWebsite`, `createPackage`, `listPackages`, `deletePackage`, `modifyPackage`, `createDatabase`, `deleteDatabase`, `listDatabases`, `createNameServer`, `createDNSZone`, `deleteZone`, `addDeleteRecords`, `createEmail`, `listEmails`, `deleteEmail`, `emailForwarding`, `changeEmailPassword`, `dkimManager`, `createFTPAccount`, `deleteFTPAccount`, `listFTPAccounts`, `createBackup`, `restoreBackup`, `addDeleteDestinations`, `scheDuleBackups`, `remoteBackups`, `manageSSL`, `hostnameSSL`, `mailServerSSL`) VALUES
(1, 'admin', 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0),
(2, 'reseller', 0, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0),
(3, 'user', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0);

-- --------------------------------------------------------

--
-- Structure de la table `loginSystem_administrator`
--

CREATE TABLE `loginSystem_administrator` (
  `id` int(11) NOT NULL,
  `userName` varchar(50) NOT NULL,
  `password` varchar(200) NOT NULL,
  `firstName` varchar(20) NOT NULL,
  `lastName` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  `type` int(11) NOT NULL,
  `owner` int(11) NOT NULL,
  `token` varchar(500) NOT NULL,
  `api` int(11) NOT NULL,
  `securityLevel` int(11) NOT NULL,
  `state` varchar(10) NOT NULL,
  `initWebsitesLimit` int(11) NOT NULL,
  `twoFA` int(11) NOT NULL,
  `secretKey` varchar(50) NOT NULL,
  `acl_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `loginSystem_administrator`
--

INSERT INTO `loginSystem_administrator` (`id`, `userName`, `password`, `firstName`, `lastName`, `email`, `type`, `owner`, `token`, `api`, `securityLevel`, `state`, `initWebsitesLimit`, `twoFA`, `secretKey`, `acl_id`) VALUES
(1, 'admin', '30d67298d4db1d9a6b843878e8b0503e9f2e1119a3f40b4ffcd43e188725462e:3ff433055b4e4df29350475efedb5021', 'Cyber', 'Panel', 'usman@cyberpersons.com', 1, 1, 'Basic YWRtaW46TGhsNDdeYzNHTTZWeUZCOUFDcGY4UlhnIzFaZW52', 0, 0, 'ACTIVE', 0, 0, 'None', 1);

-- --------------------------------------------------------

--
-- Structure de la table `mailServer_pipeprograms`
--

CREATE TABLE `mailServer_pipeprograms` (
  `id` int(11) NOT NULL,
  `source` varchar(80) NOT NULL,
  `destination` longtext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `managePHP_apachephp`
--

CREATE TABLE `managePHP_apachephp` (
  `id` int(11) NOT NULL,
  `phpVers` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `managePHP_installedpackages`
--

CREATE TABLE `managePHP_installedpackages` (
  `id` int(11) NOT NULL,
  `extensionName` varchar(50) NOT NULL,
  `description` varchar(255) NOT NULL,
  `status` int(11) NOT NULL,
  `phpVers_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `managePHP_installedpackagesapache`
--

CREATE TABLE `managePHP_installedpackagesapache` (
  `id` int(11) NOT NULL,
  `extensionName` varchar(50) NOT NULL,
  `description` varchar(255) NOT NULL,
  `status` int(11) NOT NULL,
  `phpVers_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `managePHP_php`
--

CREATE TABLE `managePHP_php` (
  `id` int(11) NOT NULL,
  `phpVers` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `manageServices_pdnsstatus`
--

CREATE TABLE `manageServices_pdnsstatus` (
  `id` int(11) NOT NULL,
  `serverStatus` int(11) NOT NULL,
  `type` varchar(6) NOT NULL,
  `masterServer` varchar(200) NOT NULL,
  `masterIP` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `manageServices_pdnsstatus`
--

INSERT INTO `manageServices_pdnsstatus` (`id`, `serverStatus`, `type`, `masterServer`, `masterIP`) VALUES
(1, 1, 'NATIVE', '', '');

-- --------------------------------------------------------

--
-- Structure de la table `manageServices_slaveservers`
--

CREATE TABLE `manageServices_slaveservers` (
  `id` int(11) NOT NULL,
  `slaveServer` varchar(200) NOT NULL,
  `slaveServerIP` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `packages_package`
--

CREATE TABLE `packages_package` (
  `id` int(11) NOT NULL,
  `packageName` varchar(50) NOT NULL,
  `diskSpace` int(11) NOT NULL,
  `bandwidth` int(11) NOT NULL,
  `emailAccounts` int(11) DEFAULT NULL,
  `dataBases` int(11) NOT NULL,
  `ftpAccounts` int(11) NOT NULL,
  `allowedDomains` int(11) NOT NULL,
  `allowFullDomain` int(11) NOT NULL,
  `admin_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `packages_package`
--

INSERT INTO `packages_package` (`id`, `packageName`, `diskSpace`, `bandwidth`, `emailAccounts`, `dataBases`, `ftpAccounts`, `allowedDomains`, `allowFullDomain`, `admin_id`) VALUES
(2, 'Default', 0, 0, 1000, 1000, 1000, 0, 1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `records`
--

CREATE TABLE `records` (
  `id` bigint(20) NOT NULL,
  `domain_id` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  `content` varchar(1000) DEFAULT NULL,
  `ttl` int(11) DEFAULT NULL,
  `prio` int(11) DEFAULT NULL,
  `change_date` int(11) DEFAULT NULL,
  `disabled` int(11) DEFAULT NULL,
  `ordername` varchar(255) DEFAULT NULL,
  `auth` int(11) DEFAULT NULL,
  `domainOwner_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `records`
--

INSERT INTO `records` (`id`, `domain_id`, `name`, `type`, `content`, `ttl`, `prio`, `change_date`, `disabled`, `ordername`, `auth`, `domainOwner_id`) VALUES
(1, 1, 'er4goon.com', 'NS', 'ns1.er4goon.com', 3600, 0, NULL, 0, NULL, 1, 1),
(2, 1, 'er4goon.com', 'NS', 'ns2.er4goon.com', 3600, 0, NULL, 0, NULL, 1, 1),
(3, 1, 'er4goon.com', 'SOA', 'ns1.er4goon.com hostmaster.er4goon.com 1 10800 3600 604800 3600', 3600, 0, NULL, 0, NULL, 1, 1),
(4, 1, 'er4goon.com', 'A', '195.110.59.7', 3600, 0, NULL, 0, NULL, 1, 1),
(5, 1, 'www.er4goon.com', 'CNAME', 'er4goon.com', 3600, 0, NULL, 0, NULL, 1, 1),
(6, 1, 'ftp.er4goon.com', 'CNAME', 'er4goon.com', 3600, 0, NULL, 0, NULL, 1, 1),
(7, 1, 'er4goon.com', 'MX', 'mail.er4goon.com', 3600, 10, NULL, 0, NULL, 1, 1),
(8, 1, 'mail.er4goon.com', 'A', '195.110.59.7', 3600, 0, NULL, 0, NULL, 1, 1),
(9, 1, 'er4goon.com', 'TXT', 'v=spf1 a mx ip4:195.110.59.7 ~all', 3600, 0, NULL, 0, NULL, 1, 1),
(10, 1, '_dmarc.er4goon.com', 'TXT', 'v=DMARC1; p=none', 3600, 0, NULL, 0, NULL, 1, 1),
(11, 1, '_domainkey.er4goon.com', 'TXT', 't=y; o=~;', 3600, 0, NULL, 0, NULL, 1, 1),
(12, 1, 'default._domainkey.er4goon.com', 'TXT', '\"v=DKIM1; k=rsa; \"\n	  \"p=MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC9nBVnP21i/kZTvCMhJyY6DtSA1iiFthgvRBKSqOJ/eoO4XIbfgy+EGWdPLpi3A+q2zAccJxEy5N8f9jsq3WcFBqmfq/Ir0PJeFQcmMiyxTG+sNZtnQKyX3wiUm+W1+L0xYPBkEhhtXcCvMhyPDFF9x+zCBYgez9x/vWkbpm7yaQIDAQAB\"', 3600, 0, NULL, 0, NULL, 1, 1),
(13, 1, 'www.mail.er4goon.com', 'CNAME', 'mail.er4goon.com', 3600, 0, NULL, 0, NULL, 1, 1),
(14, 1, 'mail.er4goon.com', 'MX', 'mail.mail.er4goon.com', 3600, 10, NULL, 0, NULL, 1, 1),
(15, 1, 'mail.er4goon.com', 'TXT', 'v=spf1 a mx ip4:195.110.59.7 ~all', 3600, 0, NULL, 0, NULL, 1, 1),
(16, 1, '_dmarc.mail.er4goon.com', 'TXT', 'v=DMARC1; p=none', 3600, 0, NULL, 0, NULL, 1, 1),
(17, 1, '_domainkey.mail.er4goon.com', 'TXT', 't=y; o=~;', 3600, 0, NULL, 0, NULL, 1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `s3Backups_backuplogs`
--

CREATE TABLE `s3Backups_backuplogs` (
  `id` int(11) NOT NULL,
  `timeStamp` varchar(200) NOT NULL,
  `level` varchar(5) NOT NULL,
  `msg` varchar(500) NOT NULL,
  `owner_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `s3Backups_backuplogsdo`
--

CREATE TABLE `s3Backups_backuplogsdo` (
  `id` int(11) NOT NULL,
  `timeStamp` varchar(200) NOT NULL,
  `level` varchar(5) NOT NULL,
  `msg` varchar(500) NOT NULL,
  `owner_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `s3Backups_backuplogsminio`
--

CREATE TABLE `s3Backups_backuplogsminio` (
  `id` int(11) NOT NULL,
  `timeStamp` varchar(200) NOT NULL,
  `level` varchar(5) NOT NULL,
  `msg` varchar(500) NOT NULL,
  `owner_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `s3Backups_backupplan`
--

CREATE TABLE `s3Backups_backupplan` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `bucket` varchar(50) NOT NULL,
  `freq` varchar(50) NOT NULL,
  `retention` int(11) NOT NULL,
  `type` varchar(5) NOT NULL,
  `lastRun` varchar(50) NOT NULL,
  `config` longtext NOT NULL,
  `owner_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `s3Backups_backupplando`
--

CREATE TABLE `s3Backups_backupplando` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `bucket` varchar(50) NOT NULL,
  `freq` varchar(50) NOT NULL,
  `retention` int(11) NOT NULL,
  `type` varchar(5) NOT NULL,
  `region` varchar(5) NOT NULL,
  `lastRun` varchar(50) NOT NULL,
  `owner_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `s3Backups_backupplanminio`
--

CREATE TABLE `s3Backups_backupplanminio` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `freq` varchar(50) NOT NULL,
  `retention` int(11) NOT NULL,
  `lastRun` varchar(50) NOT NULL,
  `minioNode_id` int(11) NOT NULL,
  `owner_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `s3Backups_minionodes`
--

CREATE TABLE `s3Backups_minionodes` (
  `id` int(11) NOT NULL,
  `endPointURL` varchar(200) NOT NULL,
  `accessKey` varchar(200) NOT NULL,
  `secretKey` varchar(200) NOT NULL,
  `owner_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `s3Backups_websitesinplan`
--

CREATE TABLE `s3Backups_websitesinplan` (
  `id` int(11) NOT NULL,
  `domain` varchar(100) NOT NULL,
  `owner_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `s3Backups_websitesinplando`
--

CREATE TABLE `s3Backups_websitesinplando` (
  `id` int(11) NOT NULL,
  `domain` varchar(100) NOT NULL,
  `owner_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `s3Backups_websitesinplanminio`
--

CREATE TABLE `s3Backups_websitesinplanminio` (
  `id` int(11) NOT NULL,
  `domain` varchar(100) NOT NULL,
  `owner_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `supermasters`
--

CREATE TABLE `supermasters` (
  `ip` varchar(64) NOT NULL,
  `nameserver` varchar(255) NOT NULL,
  `account` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `tsigkeys`
--

CREATE TABLE `tsigkeys` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `algorithm` varchar(50) DEFAULT NULL,
  `secret` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE `users` (
  `ID` int(11) NOT NULL,
  `User` varchar(32) NOT NULL,
  `Password` varchar(64) NOT NULL,
  `Uid` int(11) NOT NULL,
  `Gid` int(11) NOT NULL,
  `Dir` varchar(255) NOT NULL,
  `QuotaSize` int(11) NOT NULL,
  `Status` varchar(1) NOT NULL,
  `ULBandwidth` int(11) NOT NULL,
  `DLBandwidth` int(11) NOT NULL,
  `Date` date NOT NULL,
  `LastModif` varchar(255) NOT NULL,
  `domain_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `websiteFunctions_aliasdomains`
--

CREATE TABLE `websiteFunctions_aliasdomains` (
  `id` int(11) NOT NULL,
  `aliasDomain` varchar(75) NOT NULL,
  `master_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `websiteFunctions_backupjob`
--

CREATE TABLE `websiteFunctions_backupjob` (
  `id` int(11) NOT NULL,
  `logFile` varchar(1000) NOT NULL,
  `ipAddress` varchar(50) NOT NULL,
  `port` varchar(15) NOT NULL,
  `jobSuccessSites` int(11) NOT NULL,
  `jobFailedSites` int(11) NOT NULL,
  `location` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `websiteFunctions_backupjoblogs`
--

CREATE TABLE `websiteFunctions_backupjoblogs` (
  `id` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  `message` longtext NOT NULL,
  `owner_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `websiteFunctions_backups`
--

CREATE TABLE `websiteFunctions_backups` (
  `id` int(11) NOT NULL,
  `fileName` varchar(200) NOT NULL,
  `date` varchar(50) NOT NULL,
  `size` varchar(50) NOT NULL,
  `status` int(11) NOT NULL,
  `website_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `websiteFunctions_backupschedules`
--

CREATE TABLE `websiteFunctions_backupschedules` (
  `id` int(11) NOT NULL,
  `frequency` varchar(15) NOT NULL,
  `dest_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `websiteFunctions_childdomains`
--

CREATE TABLE `websiteFunctions_childdomains` (
  `id` int(11) NOT NULL,
  `domain` varchar(50) NOT NULL,
  `path` varchar(200) NOT NULL,
  `ssl` int(11) NOT NULL,
  `phpSelection` varchar(10) NOT NULL,
  `master_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `websiteFunctions_childdomains`
--

INSERT INTO `websiteFunctions_childdomains` (`id`, `domain`, `path`, `ssl`, `phpSelection`, `master_id`) VALUES
(1, 'mail.er4goon.com', '/home/er4goon.com/public_html/mail.er4goon.com', 1, 'PHP 7.2', 1);

-- --------------------------------------------------------

--
-- Structure de la table `websiteFunctions_dest`
--

CREATE TABLE `websiteFunctions_dest` (
  `id` int(11) NOT NULL,
  `destLoc` varchar(18) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `websiteFunctions_gdrive`
--

CREATE TABLE `websiteFunctions_gdrive` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `auth` longtext NOT NULL,
  `runTime` varchar(20) NOT NULL,
  `owner_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `websiteFunctions_gdrivejoblogs`
--

CREATE TABLE `websiteFunctions_gdrivejoblogs` (
  `id` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  `message` longtext NOT NULL,
  `owner_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `websiteFunctions_gdrivesites`
--

CREATE TABLE `websiteFunctions_gdrivesites` (
  `id` int(11) NOT NULL,
  `domain` varchar(200) NOT NULL,
  `owner_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `websiteFunctions_gitlogs`
--

CREATE TABLE `websiteFunctions_gitlogs` (
  `id` int(11) NOT NULL,
  `date` datetime(6) NOT NULL,
  `type` varchar(5) NOT NULL,
  `message` longtext NOT NULL,
  `owner_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `websiteFunctions_normalbackupdests`
--

CREATE TABLE `websiteFunctions_normalbackupdests` (
  `id` int(11) NOT NULL,
  `name` varchar(25) NOT NULL,
  `config` longtext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `websiteFunctions_normalbackupjoblogs`
--

CREATE TABLE `websiteFunctions_normalbackupjoblogs` (
  `id` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  `message` longtext NOT NULL,
  `owner_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `websiteFunctions_normalbackupjobs`
--

CREATE TABLE `websiteFunctions_normalbackupjobs` (
  `id` int(11) NOT NULL,
  `name` varchar(25) NOT NULL,
  `config` longtext NOT NULL,
  `owner_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `websiteFunctions_normalbackupsites`
--

CREATE TABLE `websiteFunctions_normalbackupsites` (
  `id` int(11) NOT NULL,
  `domain_id` int(11) NOT NULL,
  `owner_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `websiteFunctions_websites`
--

CREATE TABLE `websiteFunctions_websites` (
  `id` int(11) NOT NULL,
  `domain` varchar(50) NOT NULL,
  `adminEmail` varchar(50) NOT NULL,
  `phpSelection` varchar(10) NOT NULL,
  `ssl` int(11) NOT NULL,
  `state` int(11) NOT NULL,
  `externalApp` varchar(30) NOT NULL,
  `admin_id` int(11) NOT NULL,
  `package_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `websiteFunctions_websites`
--

INSERT INTO `websiteFunctions_websites` (`id`, `domain`, `adminEmail`, `phpSelection`, `ssl`, `state`, `externalApp`, `admin_id`, `package_id`) VALUES
(1, 'er4goon.com', 'robensonrapha@protonmail.com', 'PHP 8.0', 1, 1, 'ergoo3840', 1, 2);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `auth_group`
--
ALTER TABLE `auth_group`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`);

--
-- Index pour la table `auth_group_permissions`
--
ALTER TABLE `auth_group_permissions`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `auth_group_permissions_group_id_permission_id_0cd325b0_uniq` (`group_id`,`permission_id`),
  ADD KEY `auth_group_permissio_permission_id_84c5c92e_fk_auth_perm` (`permission_id`);

--
-- Index pour la table `auth_permission`
--
ALTER TABLE `auth_permission`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `auth_permission_content_type_id_codename_01ab375a_uniq` (`content_type_id`,`codename`);

--
-- Index pour la table `auth_user`
--
ALTER TABLE `auth_user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Index pour la table `auth_user_groups`
--
ALTER TABLE `auth_user_groups`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `auth_user_groups_user_id_group_id_94350c0c_uniq` (`user_id`,`group_id`),
  ADD KEY `auth_user_groups_group_id_97559544_fk_auth_group_id` (`group_id`);

--
-- Index pour la table `auth_user_user_permissions`
--
ALTER TABLE `auth_user_user_permissions`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `auth_user_user_permissions_user_id_permission_id_14a6b632_uniq` (`user_id`,`permission_id`),
  ADD KEY `auth_user_user_permi_permission_id_1fbb5f2c_fk_auth_perm` (`permission_id`);

--
-- Index pour la table `baseTemplate_version`
--
ALTER TABLE `baseTemplate_version`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `CLManager_clpackages`
--
ALTER TABLE `CLManager_clpackages`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`),
  ADD KEY `CLManager_clpackages_owner_id_9898c1e8_fk_packages_package_id` (`owner_id`);

--
-- Index pour la table `comments`
--
ALTER TABLE `comments`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `containerization_containerlimits`
--
ALTER TABLE `containerization_containerlimits`
  ADD PRIMARY KEY (`id`),
  ADD KEY `containerization_con_owner_id_494eb637_fk_websiteFu` (`owner_id`);

--
-- Index pour la table `cryptokeys`
--
ALTER TABLE `cryptokeys`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `databases_databases`
--
ALTER TABLE `databases_databases`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `dbName` (`dbName`),
  ADD KEY `databases_databases_website_id_fb864a69_fk_websiteFu` (`website_id`);

--
-- Index pour la table `databases_dbmeta`
--
ALTER TABLE `databases_dbmeta`
  ADD PRIMARY KEY (`id`),
  ADD KEY `databases_dbmeta_database_id_777997bc_fk_databases_databases_id` (`database_id`);

--
-- Index pour la table `databases_globaluserdb`
--
ALTER TABLE `databases_globaluserdb`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `django_admin_log`
--
ALTER TABLE `django_admin_log`
  ADD PRIMARY KEY (`id`),
  ADD KEY `django_admin_log_content_type_id_c4bce8eb_fk_django_co` (`content_type_id`),
  ADD KEY `django_admin_log_user_id_c564eba6_fk_auth_user_id` (`user_id`);

--
-- Index pour la table `django_content_type`
--
ALTER TABLE `django_content_type`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `django_content_type_app_label_model_76bd3d3b_uniq` (`app_label`,`model`);

--
-- Index pour la table `django_migrations`
--
ALTER TABLE `django_migrations`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `django_session`
--
ALTER TABLE `django_session`
  ADD PRIMARY KEY (`session_key`),
  ADD KEY `django_session_expire_date_a5c62663` (`expire_date`);

--
-- Index pour la table `dockerManager_containers`
--
ALTER TABLE `dockerManager_containers`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`),
  ADD KEY `dockerManager_contai_admin_id_58fb62b7_fk_loginSyst` (`admin_id`);

--
-- Index pour la table `domainmetadata`
--
ALTER TABLE `domainmetadata`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `domains`
--
ALTER TABLE `domains`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`),
  ADD KEY `domains_admin_id_c9d09cb8_fk_loginSystem_administrator_id` (`admin_id`);

--
-- Index pour la table `emailMarketing_emailjobs`
--
ALTER TABLE `emailMarketing_emailjobs`
  ADD PRIMARY KEY (`id`),
  ADD KEY `emailMarketing_email_owner_id_73ee4827_fk_emailMark` (`owner_id`);

--
-- Index pour la table `emailMarketing_emaillists`
--
ALTER TABLE `emailMarketing_emaillists`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `listName` (`listName`),
  ADD KEY `emailMarketing_email_owner_id_bf1b4530_fk_websiteFu` (`owner_id`);

--
-- Index pour la table `emailMarketing_emailmarketing`
--
ALTER TABLE `emailMarketing_emailmarketing`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `userName` (`userName`);

--
-- Index pour la table `emailMarketing_emailsinlist`
--
ALTER TABLE `emailMarketing_emailsinlist`
  ADD PRIMARY KEY (`id`),
  ADD KEY `emailMarketing_email_owner_id_c5c27005_fk_emailMark` (`owner_id`);

--
-- Index pour la table `emailMarketing_emailtemplate`
--
ALTER TABLE `emailMarketing_emailtemplate`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`),
  ADD KEY `emailMarketing_email_owner_id_d27e1d00_fk_loginSyst` (`owner_id`);

--
-- Index pour la table `emailMarketing_smtphosts`
--
ALTER TABLE `emailMarketing_smtphosts`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `host` (`host`),
  ADD KEY `emailMarketing_smtph_owner_id_8b2d4ac7_fk_loginSyst` (`owner_id`);

--
-- Index pour la table `emailMarketing_validationlog`
--
ALTER TABLE `emailMarketing_validationlog`
  ADD PRIMARY KEY (`id`),
  ADD KEY `emailMarketing_valid_owner_id_240ad36e_fk_emailMark` (`owner_id`);

--
-- Index pour la table `emailPremium_domainlimits`
--
ALTER TABLE `emailPremium_domainlimits`
  ADD PRIMARY KEY (`id`),
  ADD KEY `emailPremium_domainlimits_domain_id_303ab297_fk_e_domains_domain` (`domain_id`);

--
-- Index pour la table `emailPremium_emaillimits`
--
ALTER TABLE `emailPremium_emaillimits`
  ADD PRIMARY KEY (`id`),
  ADD KEY `emailPremium_emaillimits_email_id_1c111df5_fk_e_users_email` (`email_id`);

--
-- Index pour la table `emailPremium_emaillogs`
--
ALTER TABLE `emailPremium_emaillogs`
  ADD PRIMARY KEY (`id`),
  ADD KEY `emailPremium_emaillogs_email_id_9ef49552_fk_e_users_email` (`email_id`);

--
-- Index pour la table `e_domains`
--
ALTER TABLE `e_domains`
  ADD PRIMARY KEY (`domain`),
  ADD KEY `e_domains_childOwner_id_6c9fd49d_fk_websiteFu` (`childOwner_id`),
  ADD KEY `e_domains_domainOwner_id_581e752a_fk_websiteFu` (`domainOwner_id`);

--
-- Index pour la table `e_forwardings`
--
ALTER TABLE `e_forwardings`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `e_transport`
--
ALTER TABLE `e_transport`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `domain` (`domain`);

--
-- Index pour la table `e_users`
--
ALTER TABLE `e_users`
  ADD PRIMARY KEY (`email`),
  ADD KEY `e_users_emailOwner_id_761bf267_fk_e_domains_domain` (`emailOwner_id`);

--
-- Index pour la table `filemanager_trash`
--
ALTER TABLE `filemanager_trash`
  ADD PRIMARY KEY (`id`),
  ADD KEY `filemanager_trash_website_id_e2762f3c_fk_websiteFu` (`website_id`);

--
-- Index pour la table `firewall_firewallrules`
--
ALTER TABLE `firewall_firewallrules`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`);

--
-- Index pour la table `IncBackups_backupjob`
--
ALTER TABLE `IncBackups_backupjob`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `IncBackups_incjob`
--
ALTER TABLE `IncBackups_incjob`
  ADD PRIMARY KEY (`id`),
  ADD KEY `IncBackups_incjob_website_id_aad31bf6_fk_websiteFu` (`website_id`);

--
-- Index pour la table `IncBackups_jobsites`
--
ALTER TABLE `IncBackups_jobsites`
  ADD PRIMARY KEY (`id`),
  ADD KEY `IncBackups_jobsites_job_id_494a1f69_fk_IncBackups_backupjob_id` (`job_id`);

--
-- Index pour la table `IncBackups_jobsnapshots`
--
ALTER TABLE `IncBackups_jobsnapshots`
  ADD PRIMARY KEY (`id`),
  ADD KEY `IncBackups_jobsnapshots_job_id_a8237ca8_fk_IncBackups_incjob_id` (`job_id`);

--
-- Index pour la table `loginSystem_acl`
--
ALTER TABLE `loginSystem_acl`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`);

--
-- Index pour la table `loginSystem_administrator`
--
ALTER TABLE `loginSystem_administrator`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `userName` (`userName`),
  ADD KEY `loginSystem_administrator_acl_id_1ec0dc78_fk_loginSystem_acl_id` (`acl_id`);

--
-- Index pour la table `mailServer_pipeprograms`
--
ALTER TABLE `mailServer_pipeprograms`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `managePHP_apachephp`
--
ALTER TABLE `managePHP_apachephp`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `phpVers` (`phpVers`);

--
-- Index pour la table `managePHP_installedpackages`
--
ALTER TABLE `managePHP_installedpackages`
  ADD PRIMARY KEY (`id`),
  ADD KEY `managePHP_installedp_phpVers_id_54d8b7bc_fk_managePHP` (`phpVers_id`);

--
-- Index pour la table `managePHP_installedpackagesapache`
--
ALTER TABLE `managePHP_installedpackagesapache`
  ADD PRIMARY KEY (`id`),
  ADD KEY `managePHP_installedp_phpVers_id_d01eb0b2_fk_managePHP` (`phpVers_id`);

--
-- Index pour la table `managePHP_php`
--
ALTER TABLE `managePHP_php`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `phpVers` (`phpVers`);

--
-- Index pour la table `manageServices_pdnsstatus`
--
ALTER TABLE `manageServices_pdnsstatus`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `manageServices_slaveservers`
--
ALTER TABLE `manageServices_slaveservers`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `packages_package`
--
ALTER TABLE `packages_package`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `packageName` (`packageName`),
  ADD KEY `packages_package_admin_id_23828c6a_fk_loginSyst` (`admin_id`);

--
-- Index pour la table `records`
--
ALTER TABLE `records`
  ADD PRIMARY KEY (`id`),
  ADD KEY `records_domainOwner_id_e29f5ff2_fk_domains_id` (`domainOwner_id`);

--
-- Index pour la table `s3Backups_backuplogs`
--
ALTER TABLE `s3Backups_backuplogs`
  ADD PRIMARY KEY (`id`),
  ADD KEY `s3Backups_backuplogs_owner_id_7b4653af_fk_s3Backups` (`owner_id`);

--
-- Index pour la table `s3Backups_backuplogsdo`
--
ALTER TABLE `s3Backups_backuplogsdo`
  ADD PRIMARY KEY (`id`),
  ADD KEY `s3Backups_backuplogs_owner_id_c7cb5872_fk_s3Backups` (`owner_id`);

--
-- Index pour la table `s3Backups_backuplogsminio`
--
ALTER TABLE `s3Backups_backuplogsminio`
  ADD PRIMARY KEY (`id`),
  ADD KEY `s3Backups_backuplogs_owner_id_f19e1736_fk_s3Backups` (`owner_id`);

--
-- Index pour la table `s3Backups_backupplan`
--
ALTER TABLE `s3Backups_backupplan`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`),
  ADD KEY `s3Backups_backupplan_owner_id_7d058ced_fk_loginSyst` (`owner_id`);

--
-- Index pour la table `s3Backups_backupplando`
--
ALTER TABLE `s3Backups_backupplando`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`),
  ADD KEY `s3Backups_backupplan_owner_id_1a3ec86d_fk_loginSyst` (`owner_id`);

--
-- Index pour la table `s3Backups_backupplanminio`
--
ALTER TABLE `s3Backups_backupplanminio`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`),
  ADD KEY `s3Backups_backupplan_minioNode_id_a4eaf917_fk_s3Backups` (`minioNode_id`),
  ADD KEY `s3Backups_backupplan_owner_id_d6830e67_fk_loginSyst` (`owner_id`);

--
-- Index pour la table `s3Backups_minionodes`
--
ALTER TABLE `s3Backups_minionodes`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `endPointURL` (`endPointURL`),
  ADD UNIQUE KEY `accessKey` (`accessKey`),
  ADD KEY `s3Backups_minionodes_owner_id_e50993d9_fk_loginSyst` (`owner_id`);

--
-- Index pour la table `s3Backups_websitesinplan`
--
ALTER TABLE `s3Backups_websitesinplan`
  ADD PRIMARY KEY (`id`),
  ADD KEY `s3Backups_websitesin_owner_id_0e9a4fe3_fk_s3Backups` (`owner_id`);

--
-- Index pour la table `s3Backups_websitesinplando`
--
ALTER TABLE `s3Backups_websitesinplando`
  ADD PRIMARY KEY (`id`),
  ADD KEY `s3Backups_websitesin_owner_id_cef3ea04_fk_s3Backups` (`owner_id`);

--
-- Index pour la table `s3Backups_websitesinplanminio`
--
ALTER TABLE `s3Backups_websitesinplanminio`
  ADD PRIMARY KEY (`id`),
  ADD KEY `s3Backups_websitesin_owner_id_224ce049_fk_s3Backups` (`owner_id`);

--
-- Index pour la table `supermasters`
--
ALTER TABLE `supermasters`
  ADD PRIMARY KEY (`ip`),
  ADD UNIQUE KEY `supermasters_ip_nameserver_1d444554_uniq` (`ip`,`nameserver`);

--
-- Index pour la table `tsigkeys`
--
ALTER TABLE `tsigkeys`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `tsigkeys_name_algorithm_6f5ee63a_uniq` (`name`,`algorithm`);

--
-- Index pour la table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `User` (`User`),
  ADD KEY `users_domain_id_d179d1af_fk_websiteFunctions_websites_id` (`domain_id`);

--
-- Index pour la table `websiteFunctions_aliasdomains`
--
ALTER TABLE `websiteFunctions_aliasdomains`
  ADD PRIMARY KEY (`id`),
  ADD KEY `websiteFunctions_ali_master_id_726c433d_fk_websiteFu` (`master_id`);

--
-- Index pour la table `websiteFunctions_backupjob`
--
ALTER TABLE `websiteFunctions_backupjob`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `websiteFunctions_backupjoblogs`
--
ALTER TABLE `websiteFunctions_backupjoblogs`
  ADD PRIMARY KEY (`id`),
  ADD KEY `websiteFunctions_bac_owner_id_af3d15f9_fk_websiteFu` (`owner_id`);

--
-- Index pour la table `websiteFunctions_backups`
--
ALTER TABLE `websiteFunctions_backups`
  ADD PRIMARY KEY (`id`),
  ADD KEY `websiteFunctions_bac_website_id_a77aa1d3_fk_websiteFu` (`website_id`);

--
-- Index pour la table `websiteFunctions_backupschedules`
--
ALTER TABLE `websiteFunctions_backupschedules`
  ADD PRIMARY KEY (`id`),
  ADD KEY `websiteFunctions_bac_dest_id_cce9d45e_fk_websiteFu` (`dest_id`);

--
-- Index pour la table `websiteFunctions_childdomains`
--
ALTER TABLE `websiteFunctions_childdomains`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `domain` (`domain`),
  ADD KEY `websiteFunctions_chi_master_id_0db0702c_fk_websiteFu` (`master_id`);

--
-- Index pour la table `websiteFunctions_dest`
--
ALTER TABLE `websiteFunctions_dest`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `destLoc` (`destLoc`);

--
-- Index pour la table `websiteFunctions_gdrive`
--
ALTER TABLE `websiteFunctions_gdrive`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`),
  ADD KEY `websiteFunctions_gdr_owner_id_b5b1e86f_fk_loginSyst` (`owner_id`);

--
-- Index pour la table `websiteFunctions_gdrivejoblogs`
--
ALTER TABLE `websiteFunctions_gdrivejoblogs`
  ADD PRIMARY KEY (`id`),
  ADD KEY `websiteFunctions_gdr_owner_id_4cf7983e_fk_websiteFu` (`owner_id`);

--
-- Index pour la table `websiteFunctions_gdrivesites`
--
ALTER TABLE `websiteFunctions_gdrivesites`
  ADD PRIMARY KEY (`id`),
  ADD KEY `websiteFunctions_gdr_owner_id_ff78b305_fk_websiteFu` (`owner_id`);

--
-- Index pour la table `websiteFunctions_gitlogs`
--
ALTER TABLE `websiteFunctions_gitlogs`
  ADD PRIMARY KEY (`id`),
  ADD KEY `websiteFunctions_git_owner_id_ce74c7de_fk_websiteFu` (`owner_id`);

--
-- Index pour la table `websiteFunctions_normalbackupdests`
--
ALTER TABLE `websiteFunctions_normalbackupdests`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `websiteFunctions_normalbackupjoblogs`
--
ALTER TABLE `websiteFunctions_normalbackupjoblogs`
  ADD PRIMARY KEY (`id`),
  ADD KEY `websiteFunctions_nor_owner_id_69403e73_fk_websiteFu` (`owner_id`);

--
-- Index pour la table `websiteFunctions_normalbackupjobs`
--
ALTER TABLE `websiteFunctions_normalbackupjobs`
  ADD PRIMARY KEY (`id`),
  ADD KEY `websiteFunctions_nor_owner_id_3a7a13db_fk_websiteFu` (`owner_id`);

--
-- Index pour la table `websiteFunctions_normalbackupsites`
--
ALTER TABLE `websiteFunctions_normalbackupsites`
  ADD PRIMARY KEY (`id`),
  ADD KEY `websiteFunctions_nor_domain_id_c03362bc_fk_websiteFu` (`domain_id`),
  ADD KEY `websiteFunctions_nor_owner_id_c6ece6cc_fk_websiteFu` (`owner_id`);

--
-- Index pour la table `websiteFunctions_websites`
--
ALTER TABLE `websiteFunctions_websites`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `domain` (`domain`),
  ADD KEY `websiteFunctions_web_admin_id_9c73217c_fk_loginSyst` (`admin_id`),
  ADD KEY `websiteFunctions_web_package_id_d266bd7a_fk_packages_` (`package_id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `auth_group`
--
ALTER TABLE `auth_group`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `auth_group_permissions`
--
ALTER TABLE `auth_group_permissions`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `auth_permission`
--
ALTER TABLE `auth_permission`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=313;

--
-- AUTO_INCREMENT pour la table `auth_user`
--
ALTER TABLE `auth_user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `auth_user_groups`
--
ALTER TABLE `auth_user_groups`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `auth_user_user_permissions`
--
ALTER TABLE `auth_user_user_permissions`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `baseTemplate_version`
--
ALTER TABLE `baseTemplate_version`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `CLManager_clpackages`
--
ALTER TABLE `CLManager_clpackages`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `comments`
--
ALTER TABLE `comments`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `containerization_containerlimits`
--
ALTER TABLE `containerization_containerlimits`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `cryptokeys`
--
ALTER TABLE `cryptokeys`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `databases_databases`
--
ALTER TABLE `databases_databases`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `databases_dbmeta`
--
ALTER TABLE `databases_dbmeta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `databases_globaluserdb`
--
ALTER TABLE `databases_globaluserdb`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT pour la table `django_admin_log`
--
ALTER TABLE `django_admin_log`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `django_content_type`
--
ALTER TABLE `django_content_type`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=79;

--
-- AUTO_INCREMENT pour la table `django_migrations`
--
ALTER TABLE `django_migrations`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;

--
-- AUTO_INCREMENT pour la table `dockerManager_containers`
--
ALTER TABLE `dockerManager_containers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `domainmetadata`
--
ALTER TABLE `domainmetadata`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `domains`
--
ALTER TABLE `domains`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `emailMarketing_emailjobs`
--
ALTER TABLE `emailMarketing_emailjobs`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `emailMarketing_emaillists`
--
ALTER TABLE `emailMarketing_emaillists`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `emailMarketing_emailmarketing`
--
ALTER TABLE `emailMarketing_emailmarketing`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `emailMarketing_emailsinlist`
--
ALTER TABLE `emailMarketing_emailsinlist`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `emailMarketing_emailtemplate`
--
ALTER TABLE `emailMarketing_emailtemplate`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `emailMarketing_smtphosts`
--
ALTER TABLE `emailMarketing_smtphosts`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `emailMarketing_validationlog`
--
ALTER TABLE `emailMarketing_validationlog`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `emailPremium_domainlimits`
--
ALTER TABLE `emailPremium_domainlimits`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `emailPremium_emaillimits`
--
ALTER TABLE `emailPremium_emaillimits`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `emailPremium_emaillogs`
--
ALTER TABLE `emailPremium_emaillogs`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `e_forwardings`
--
ALTER TABLE `e_forwardings`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `e_transport`
--
ALTER TABLE `e_transport`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `filemanager_trash`
--
ALTER TABLE `filemanager_trash`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `firewall_firewallrules`
--
ALTER TABLE `firewall_firewallrules`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT pour la table `IncBackups_backupjob`
--
ALTER TABLE `IncBackups_backupjob`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `IncBackups_incjob`
--
ALTER TABLE `IncBackups_incjob`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `IncBackups_jobsites`
--
ALTER TABLE `IncBackups_jobsites`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `IncBackups_jobsnapshots`
--
ALTER TABLE `IncBackups_jobsnapshots`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `loginSystem_acl`
--
ALTER TABLE `loginSystem_acl`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `loginSystem_administrator`
--
ALTER TABLE `loginSystem_administrator`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `mailServer_pipeprograms`
--
ALTER TABLE `mailServer_pipeprograms`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `managePHP_apachephp`
--
ALTER TABLE `managePHP_apachephp`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `managePHP_installedpackages`
--
ALTER TABLE `managePHP_installedpackages`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `managePHP_installedpackagesapache`
--
ALTER TABLE `managePHP_installedpackagesapache`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `managePHP_php`
--
ALTER TABLE `managePHP_php`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `manageServices_pdnsstatus`
--
ALTER TABLE `manageServices_pdnsstatus`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `manageServices_slaveservers`
--
ALTER TABLE `manageServices_slaveservers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `packages_package`
--
ALTER TABLE `packages_package`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `records`
--
ALTER TABLE `records`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT pour la table `s3Backups_backuplogs`
--
ALTER TABLE `s3Backups_backuplogs`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `s3Backups_backuplogsdo`
--
ALTER TABLE `s3Backups_backuplogsdo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `s3Backups_backuplogsminio`
--
ALTER TABLE `s3Backups_backuplogsminio`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `s3Backups_backupplan`
--
ALTER TABLE `s3Backups_backupplan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `s3Backups_backupplando`
--
ALTER TABLE `s3Backups_backupplando`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `s3Backups_backupplanminio`
--
ALTER TABLE `s3Backups_backupplanminio`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `s3Backups_minionodes`
--
ALTER TABLE `s3Backups_minionodes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `s3Backups_websitesinplan`
--
ALTER TABLE `s3Backups_websitesinplan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `s3Backups_websitesinplando`
--
ALTER TABLE `s3Backups_websitesinplando`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `s3Backups_websitesinplanminio`
--
ALTER TABLE `s3Backups_websitesinplanminio`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `tsigkeys`
--
ALTER TABLE `tsigkeys`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `users`
--
ALTER TABLE `users`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `websiteFunctions_aliasdomains`
--
ALTER TABLE `websiteFunctions_aliasdomains`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `websiteFunctions_backupjob`
--
ALTER TABLE `websiteFunctions_backupjob`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `websiteFunctions_backupjoblogs`
--
ALTER TABLE `websiteFunctions_backupjoblogs`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `websiteFunctions_backups`
--
ALTER TABLE `websiteFunctions_backups`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `websiteFunctions_backupschedules`
--
ALTER TABLE `websiteFunctions_backupschedules`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `websiteFunctions_childdomains`
--
ALTER TABLE `websiteFunctions_childdomains`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `websiteFunctions_dest`
--
ALTER TABLE `websiteFunctions_dest`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `websiteFunctions_gdrive`
--
ALTER TABLE `websiteFunctions_gdrive`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `websiteFunctions_gdrivejoblogs`
--
ALTER TABLE `websiteFunctions_gdrivejoblogs`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `websiteFunctions_gdrivesites`
--
ALTER TABLE `websiteFunctions_gdrivesites`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `websiteFunctions_gitlogs`
--
ALTER TABLE `websiteFunctions_gitlogs`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `websiteFunctions_normalbackupdests`
--
ALTER TABLE `websiteFunctions_normalbackupdests`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `websiteFunctions_normalbackupjoblogs`
--
ALTER TABLE `websiteFunctions_normalbackupjoblogs`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `websiteFunctions_normalbackupjobs`
--
ALTER TABLE `websiteFunctions_normalbackupjobs`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `websiteFunctions_normalbackupsites`
--
ALTER TABLE `websiteFunctions_normalbackupsites`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `websiteFunctions_websites`
--
ALTER TABLE `websiteFunctions_websites`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `auth_group_permissions`
--
ALTER TABLE `auth_group_permissions`
  ADD CONSTRAINT `auth_group_permissio_permission_id_84c5c92e_fk_auth_perm` FOREIGN KEY (`permission_id`) REFERENCES `auth_permission` (`id`),
  ADD CONSTRAINT `auth_group_permissions_group_id_b120cbf9_fk_auth_group_id` FOREIGN KEY (`group_id`) REFERENCES `auth_group` (`id`);

--
-- Contraintes pour la table `auth_permission`
--
ALTER TABLE `auth_permission`
  ADD CONSTRAINT `auth_permission_content_type_id_2f476e4b_fk_django_co` FOREIGN KEY (`content_type_id`) REFERENCES `django_content_type` (`id`);

--
-- Contraintes pour la table `auth_user_groups`
--
ALTER TABLE `auth_user_groups`
  ADD CONSTRAINT `auth_user_groups_group_id_97559544_fk_auth_group_id` FOREIGN KEY (`group_id`) REFERENCES `auth_group` (`id`),
  ADD CONSTRAINT `auth_user_groups_user_id_6a12ed8b_fk_auth_user_id` FOREIGN KEY (`user_id`) REFERENCES `auth_user` (`id`);

--
-- Contraintes pour la table `auth_user_user_permissions`
--
ALTER TABLE `auth_user_user_permissions`
  ADD CONSTRAINT `auth_user_user_permi_permission_id_1fbb5f2c_fk_auth_perm` FOREIGN KEY (`permission_id`) REFERENCES `auth_permission` (`id`),
  ADD CONSTRAINT `auth_user_user_permissions_user_id_a95ead1b_fk_auth_user_id` FOREIGN KEY (`user_id`) REFERENCES `auth_user` (`id`);

--
-- Contraintes pour la table `CLManager_clpackages`
--
ALTER TABLE `CLManager_clpackages`
  ADD CONSTRAINT `CLManager_clpackages_owner_id_9898c1e8_fk_packages_package_id` FOREIGN KEY (`owner_id`) REFERENCES `packages_package` (`id`);

--
-- Contraintes pour la table `containerization_containerlimits`
--
ALTER TABLE `containerization_containerlimits`
  ADD CONSTRAINT `containerization_con_owner_id_494eb637_fk_websiteFu` FOREIGN KEY (`owner_id`) REFERENCES `websiteFunctions_websites` (`id`);

--
-- Contraintes pour la table `databases_databases`
--
ALTER TABLE `databases_databases`
  ADD CONSTRAINT `databases_databases_website_id_fb864a69_fk_websiteFu` FOREIGN KEY (`website_id`) REFERENCES `websiteFunctions_websites` (`id`);

--
-- Contraintes pour la table `databases_dbmeta`
--
ALTER TABLE `databases_dbmeta`
  ADD CONSTRAINT `databases_dbmeta_database_id_777997bc_fk_databases_databases_id` FOREIGN KEY (`database_id`) REFERENCES `databases_databases` (`id`);

--
-- Contraintes pour la table `django_admin_log`
--
ALTER TABLE `django_admin_log`
  ADD CONSTRAINT `django_admin_log_content_type_id_c4bce8eb_fk_django_co` FOREIGN KEY (`content_type_id`) REFERENCES `django_content_type` (`id`),
  ADD CONSTRAINT `django_admin_log_user_id_c564eba6_fk_auth_user_id` FOREIGN KEY (`user_id`) REFERENCES `auth_user` (`id`);

--
-- Contraintes pour la table `dockerManager_containers`
--
ALTER TABLE `dockerManager_containers`
  ADD CONSTRAINT `dockerManager_contai_admin_id_58fb62b7_fk_loginSyst` FOREIGN KEY (`admin_id`) REFERENCES `loginSystem_administrator` (`id`);

--
-- Contraintes pour la table `domains`
--
ALTER TABLE `domains`
  ADD CONSTRAINT `domains_admin_id_c9d09cb8_fk_loginSystem_administrator_id` FOREIGN KEY (`admin_id`) REFERENCES `loginSystem_administrator` (`id`);

--
-- Contraintes pour la table `emailMarketing_emailjobs`
--
ALTER TABLE `emailMarketing_emailjobs`
  ADD CONSTRAINT `emailMarketing_email_owner_id_73ee4827_fk_emailMark` FOREIGN KEY (`owner_id`) REFERENCES `emailMarketing_emailtemplate` (`id`);

--
-- Contraintes pour la table `emailMarketing_emaillists`
--
ALTER TABLE `emailMarketing_emaillists`
  ADD CONSTRAINT `emailMarketing_email_owner_id_bf1b4530_fk_websiteFu` FOREIGN KEY (`owner_id`) REFERENCES `websiteFunctions_websites` (`id`);

--
-- Contraintes pour la table `emailMarketing_emailsinlist`
--
ALTER TABLE `emailMarketing_emailsinlist`
  ADD CONSTRAINT `emailMarketing_email_owner_id_c5c27005_fk_emailMark` FOREIGN KEY (`owner_id`) REFERENCES `emailMarketing_emaillists` (`id`);

--
-- Contraintes pour la table `emailMarketing_emailtemplate`
--
ALTER TABLE `emailMarketing_emailtemplate`
  ADD CONSTRAINT `emailMarketing_email_owner_id_d27e1d00_fk_loginSyst` FOREIGN KEY (`owner_id`) REFERENCES `loginSystem_administrator` (`id`);

--
-- Contraintes pour la table `emailMarketing_smtphosts`
--
ALTER TABLE `emailMarketing_smtphosts`
  ADD CONSTRAINT `emailMarketing_smtph_owner_id_8b2d4ac7_fk_loginSyst` FOREIGN KEY (`owner_id`) REFERENCES `loginSystem_administrator` (`id`);

--
-- Contraintes pour la table `emailMarketing_validationlog`
--
ALTER TABLE `emailMarketing_validationlog`
  ADD CONSTRAINT `emailMarketing_valid_owner_id_240ad36e_fk_emailMark` FOREIGN KEY (`owner_id`) REFERENCES `emailMarketing_emaillists` (`id`);

--
-- Contraintes pour la table `emailPremium_domainlimits`
--
ALTER TABLE `emailPremium_domainlimits`
  ADD CONSTRAINT `emailPremium_domainlimits_domain_id_303ab297_fk_e_domains_domain` FOREIGN KEY (`domain_id`) REFERENCES `e_domains` (`domain`);

--
-- Contraintes pour la table `emailPremium_emaillimits`
--
ALTER TABLE `emailPremium_emaillimits`
  ADD CONSTRAINT `emailPremium_emaillimits_email_id_1c111df5_fk_e_users_email` FOREIGN KEY (`email_id`) REFERENCES `e_users` (`email`);

--
-- Contraintes pour la table `emailPremium_emaillogs`
--
ALTER TABLE `emailPremium_emaillogs`
  ADD CONSTRAINT `emailPremium_emaillogs_email_id_9ef49552_fk_e_users_email` FOREIGN KEY (`email_id`) REFERENCES `e_users` (`email`);

--
-- Contraintes pour la table `e_domains`
--
ALTER TABLE `e_domains`
  ADD CONSTRAINT `e_domains_childOwner_id_6c9fd49d_fk_websiteFu` FOREIGN KEY (`childOwner_id`) REFERENCES `websiteFunctions_childdomains` (`id`),
  ADD CONSTRAINT `e_domains_domainOwner_id_581e752a_fk_websiteFu` FOREIGN KEY (`domainOwner_id`) REFERENCES `websiteFunctions_websites` (`id`);

--
-- Contraintes pour la table `e_users`
--
ALTER TABLE `e_users`
  ADD CONSTRAINT `e_users_emailOwner_id_761bf267_fk_e_domains_domain` FOREIGN KEY (`emailOwner_id`) REFERENCES `e_domains` (`domain`);

--
-- Contraintes pour la table `filemanager_trash`
--
ALTER TABLE `filemanager_trash`
  ADD CONSTRAINT `filemanager_trash_website_id_e2762f3c_fk_websiteFu` FOREIGN KEY (`website_id`) REFERENCES `websiteFunctions_websites` (`id`);

--
-- Contraintes pour la table `IncBackups_incjob`
--
ALTER TABLE `IncBackups_incjob`
  ADD CONSTRAINT `IncBackups_incjob_website_id_aad31bf6_fk_websiteFu` FOREIGN KEY (`website_id`) REFERENCES `websiteFunctions_websites` (`id`);

--
-- Contraintes pour la table `IncBackups_jobsites`
--
ALTER TABLE `IncBackups_jobsites`
  ADD CONSTRAINT `IncBackups_jobsites_job_id_494a1f69_fk_IncBackups_backupjob_id` FOREIGN KEY (`job_id`) REFERENCES `IncBackups_backupjob` (`id`);

--
-- Contraintes pour la table `IncBackups_jobsnapshots`
--
ALTER TABLE `IncBackups_jobsnapshots`
  ADD CONSTRAINT `IncBackups_jobsnapshots_job_id_a8237ca8_fk_IncBackups_incjob_id` FOREIGN KEY (`job_id`) REFERENCES `IncBackups_incjob` (`id`);

--
-- Contraintes pour la table `loginSystem_administrator`
--
ALTER TABLE `loginSystem_administrator`
  ADD CONSTRAINT `loginSystem_administrator_acl_id_1ec0dc78_fk_loginSystem_acl_id` FOREIGN KEY (`acl_id`) REFERENCES `loginSystem_acl` (`id`);

--
-- Contraintes pour la table `managePHP_installedpackages`
--
ALTER TABLE `managePHP_installedpackages`
  ADD CONSTRAINT `managePHP_installedp_phpVers_id_54d8b7bc_fk_managePHP` FOREIGN KEY (`phpVers_id`) REFERENCES `managePHP_php` (`id`);

--
-- Contraintes pour la table `managePHP_installedpackagesapache`
--
ALTER TABLE `managePHP_installedpackagesapache`
  ADD CONSTRAINT `managePHP_installedp_phpVers_id_d01eb0b2_fk_managePHP` FOREIGN KEY (`phpVers_id`) REFERENCES `managePHP_apachephp` (`id`);

--
-- Contraintes pour la table `packages_package`
--
ALTER TABLE `packages_package`
  ADD CONSTRAINT `packages_package_admin_id_23828c6a_fk_loginSyst` FOREIGN KEY (`admin_id`) REFERENCES `loginSystem_administrator` (`id`);

--
-- Contraintes pour la table `records`
--
ALTER TABLE `records`
  ADD CONSTRAINT `records_domainOwner_id_e29f5ff2_fk_domains_id` FOREIGN KEY (`domainOwner_id`) REFERENCES `domains` (`id`);

--
-- Contraintes pour la table `s3Backups_backuplogs`
--
ALTER TABLE `s3Backups_backuplogs`
  ADD CONSTRAINT `s3Backups_backuplogs_owner_id_7b4653af_fk_s3Backups` FOREIGN KEY (`owner_id`) REFERENCES `s3Backups_backupplan` (`id`);

--
-- Contraintes pour la table `s3Backups_backuplogsdo`
--
ALTER TABLE `s3Backups_backuplogsdo`
  ADD CONSTRAINT `s3Backups_backuplogs_owner_id_c7cb5872_fk_s3Backups` FOREIGN KEY (`owner_id`) REFERENCES `s3Backups_backupplando` (`id`);

--
-- Contraintes pour la table `s3Backups_backuplogsminio`
--
ALTER TABLE `s3Backups_backuplogsminio`
  ADD CONSTRAINT `s3Backups_backuplogs_owner_id_f19e1736_fk_s3Backups` FOREIGN KEY (`owner_id`) REFERENCES `s3Backups_backupplanminio` (`id`);

--
-- Contraintes pour la table `s3Backups_backupplan`
--
ALTER TABLE `s3Backups_backupplan`
  ADD CONSTRAINT `s3Backups_backupplan_owner_id_7d058ced_fk_loginSyst` FOREIGN KEY (`owner_id`) REFERENCES `loginSystem_administrator` (`id`);

--
-- Contraintes pour la table `s3Backups_backupplando`
--
ALTER TABLE `s3Backups_backupplando`
  ADD CONSTRAINT `s3Backups_backupplan_owner_id_1a3ec86d_fk_loginSyst` FOREIGN KEY (`owner_id`) REFERENCES `loginSystem_administrator` (`id`);

--
-- Contraintes pour la table `s3Backups_backupplanminio`
--
ALTER TABLE `s3Backups_backupplanminio`
  ADD CONSTRAINT `s3Backups_backupplan_minioNode_id_a4eaf917_fk_s3Backups` FOREIGN KEY (`minioNode_id`) REFERENCES `s3Backups_minionodes` (`id`),
  ADD CONSTRAINT `s3Backups_backupplan_owner_id_d6830e67_fk_loginSyst` FOREIGN KEY (`owner_id`) REFERENCES `loginSystem_administrator` (`id`);

--
-- Contraintes pour la table `s3Backups_minionodes`
--
ALTER TABLE `s3Backups_minionodes`
  ADD CONSTRAINT `s3Backups_minionodes_owner_id_e50993d9_fk_loginSyst` FOREIGN KEY (`owner_id`) REFERENCES `loginSystem_administrator` (`id`);

--
-- Contraintes pour la table `s3Backups_websitesinplan`
--
ALTER TABLE `s3Backups_websitesinplan`
  ADD CONSTRAINT `s3Backups_websitesin_owner_id_0e9a4fe3_fk_s3Backups` FOREIGN KEY (`owner_id`) REFERENCES `s3Backups_backupplan` (`id`);

--
-- Contraintes pour la table `s3Backups_websitesinplando`
--
ALTER TABLE `s3Backups_websitesinplando`
  ADD CONSTRAINT `s3Backups_websitesin_owner_id_cef3ea04_fk_s3Backups` FOREIGN KEY (`owner_id`) REFERENCES `s3Backups_backupplando` (`id`);

--
-- Contraintes pour la table `s3Backups_websitesinplanminio`
--
ALTER TABLE `s3Backups_websitesinplanminio`
  ADD CONSTRAINT `s3Backups_websitesin_owner_id_224ce049_fk_s3Backups` FOREIGN KEY (`owner_id`) REFERENCES `s3Backups_backupplanminio` (`id`);

--
-- Contraintes pour la table `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `users_domain_id_d179d1af_fk_websiteFunctions_websites_id` FOREIGN KEY (`domain_id`) REFERENCES `websiteFunctions_websites` (`id`);

--
-- Contraintes pour la table `websiteFunctions_aliasdomains`
--
ALTER TABLE `websiteFunctions_aliasdomains`
  ADD CONSTRAINT `websiteFunctions_ali_master_id_726c433d_fk_websiteFu` FOREIGN KEY (`master_id`) REFERENCES `websiteFunctions_websites` (`id`);

--
-- Contraintes pour la table `websiteFunctions_backupjoblogs`
--
ALTER TABLE `websiteFunctions_backupjoblogs`
  ADD CONSTRAINT `websiteFunctions_bac_owner_id_af3d15f9_fk_websiteFu` FOREIGN KEY (`owner_id`) REFERENCES `websiteFunctions_backupjob` (`id`);

--
-- Contraintes pour la table `websiteFunctions_backups`
--
ALTER TABLE `websiteFunctions_backups`
  ADD CONSTRAINT `websiteFunctions_bac_website_id_a77aa1d3_fk_websiteFu` FOREIGN KEY (`website_id`) REFERENCES `websiteFunctions_websites` (`id`);

--
-- Contraintes pour la table `websiteFunctions_backupschedules`
--
ALTER TABLE `websiteFunctions_backupschedules`
  ADD CONSTRAINT `websiteFunctions_bac_dest_id_cce9d45e_fk_websiteFu` FOREIGN KEY (`dest_id`) REFERENCES `websiteFunctions_dest` (`id`);

--
-- Contraintes pour la table `websiteFunctions_childdomains`
--
ALTER TABLE `websiteFunctions_childdomains`
  ADD CONSTRAINT `websiteFunctions_chi_master_id_0db0702c_fk_websiteFu` FOREIGN KEY (`master_id`) REFERENCES `websiteFunctions_websites` (`id`);

--
-- Contraintes pour la table `websiteFunctions_gdrive`
--
ALTER TABLE `websiteFunctions_gdrive`
  ADD CONSTRAINT `websiteFunctions_gdr_owner_id_b5b1e86f_fk_loginSyst` FOREIGN KEY (`owner_id`) REFERENCES `loginSystem_administrator` (`id`);

--
-- Contraintes pour la table `websiteFunctions_gdrivejoblogs`
--
ALTER TABLE `websiteFunctions_gdrivejoblogs`
  ADD CONSTRAINT `websiteFunctions_gdr_owner_id_4cf7983e_fk_websiteFu` FOREIGN KEY (`owner_id`) REFERENCES `websiteFunctions_gdrive` (`id`);

--
-- Contraintes pour la table `websiteFunctions_gdrivesites`
--
ALTER TABLE `websiteFunctions_gdrivesites`
  ADD CONSTRAINT `websiteFunctions_gdr_owner_id_ff78b305_fk_websiteFu` FOREIGN KEY (`owner_id`) REFERENCES `websiteFunctions_gdrive` (`id`);

--
-- Contraintes pour la table `websiteFunctions_gitlogs`
--
ALTER TABLE `websiteFunctions_gitlogs`
  ADD CONSTRAINT `websiteFunctions_git_owner_id_ce74c7de_fk_websiteFu` FOREIGN KEY (`owner_id`) REFERENCES `websiteFunctions_websites` (`id`);

--
-- Contraintes pour la table `websiteFunctions_normalbackupjoblogs`
--
ALTER TABLE `websiteFunctions_normalbackupjoblogs`
  ADD CONSTRAINT `websiteFunctions_nor_owner_id_69403e73_fk_websiteFu` FOREIGN KEY (`owner_id`) REFERENCES `websiteFunctions_normalbackupjobs` (`id`);

--
-- Contraintes pour la table `websiteFunctions_normalbackupjobs`
--
ALTER TABLE `websiteFunctions_normalbackupjobs`
  ADD CONSTRAINT `websiteFunctions_nor_owner_id_3a7a13db_fk_websiteFu` FOREIGN KEY (`owner_id`) REFERENCES `websiteFunctions_normalbackupdests` (`id`);

--
-- Contraintes pour la table `websiteFunctions_normalbackupsites`
--
ALTER TABLE `websiteFunctions_normalbackupsites`
  ADD CONSTRAINT `websiteFunctions_nor_domain_id_c03362bc_fk_websiteFu` FOREIGN KEY (`domain_id`) REFERENCES `websiteFunctions_websites` (`id`),
  ADD CONSTRAINT `websiteFunctions_nor_owner_id_c6ece6cc_fk_websiteFu` FOREIGN KEY (`owner_id`) REFERENCES `websiteFunctions_normalbackupjobs` (`id`);

--
-- Contraintes pour la table `websiteFunctions_websites`
--
ALTER TABLE `websiteFunctions_websites`
  ADD CONSTRAINT `websiteFunctions_web_admin_id_9c73217c_fk_loginSyst` FOREIGN KEY (`admin_id`) REFERENCES `loginSystem_administrator` (`id`),
  ADD CONSTRAINT `websiteFunctions_web_package_id_d266bd7a_fk_packages_` FOREIGN KEY (`package_id`) REFERENCES `packages_package` (`id`);
--
-- Base de données : `er4g_ExamApp`
--
CREATE DATABASE IF NOT EXISTS `er4g_ExamApp` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `er4g_ExamApp`;

-- --------------------------------------------------------

--
-- Structure de la table `ALieuAvant`
--

CREATE TABLE `ALieuAvant` (
  `idExamen` int(11) NOT NULL,
  `idExamen_Examens` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `Concerne`
--

CREATE TABLE `Concerne` (
  `idEtuListe` int(11) NOT NULL,
  `idExamen` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `Concerne`
--

INSERT INTO `Concerne` (`idEtuListe`, `idExamen`) VALUES
(1, 6),
(2, 3),
(3, 8),
(4, 9),
(5, 3),
(6, 2),
(7, 7),
(8, 10),
(9, 13),
(10, 6),
(11, 11),
(12, 5),
(13, 4),
(14, 12),
(15, 3);

-- --------------------------------------------------------

--
-- Structure de la table `Etudiants`
--

CREATE TABLE `Etudiants` (
  `numEtu` char(8) COLLATE utf8mb4_unicode_ci NOT NULL,
  `nom` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `prenom` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(250) COLLATE utf8mb4_unicode_ci NOT NULL,
  `idEtuListe` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `Etudiants`
--

INSERT INTO `Etudiants` (`numEtu`, `nom`, `prenom`, `email`, `idEtuListe`) VALUES
('21903008', 'Hewitt', 'Willian ', 'Willian@Willian .fr', 4),
('21903012', 'Hood', 'Harriette ', 'Harriette@Harriette.fr', 14),
('21903123', 'Craig', 'Lore ', 'decyjybej-8039@yopmail.com', 1),
('21903168', 'Bone', 'Leeann ', 'Hargrgrg@Hrukette.fr', 1),
('21903179', 'Begum', 'Dwain ', 'multiplx@outlook.com', 1),
('21903408', 'Leigh', 'Lezlie ', 'rgrgrgrgiette@Harriette.fr', 7),
('21903480', 'Taylor', 'Chanel ', 'jandrese@comcast.net', 15),
('21903485', 'Farrington', 'Nettie ', 'sakusha@verizon.net', 1),
('21903634', 'Peacock', 'Reed ', 'jespley@icloud.com', 6),
('21903635', 'Leach', 'Tonette ', 'jfinke@yahoo.ca', 3),
('21903728', 'Fitzgerald', 'Shannon ', 'pfitza@outlook.com', 6),
('21903790', 'Allan', 'Michel ', 'bescoto@optonline.net', 14),
('21903821', 'Burgess', 'Carlota ', 'duchamp@sbcglobal.net', 14),
('21903909', 'Graham', 'Florance ', 'augusto@sbcglobal.net', 9),
('21903982', 'Colley', 'Annie ', '', 10);

-- --------------------------------------------------------

--
-- Structure de la table `EtuListes`
--

CREATE TABLE `EtuListes` (
  `idEtuListe` int(11) NOT NULL,
  `libelle` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `EtuListes`
--

INSERT INTO `EtuListes` (`idEtuListe`, `libelle`) VALUES
(1, 'L1 Informatique'),
(2, 'L2 Informatique'),
(3, 'L3 Informatique'),
(4, 'M1 Informatique'),
(5, 'M2 Informatique'),
(6, 'L1 Chimie'),
(7, 'L2 Chimie'),
(8, 'L3 Chimie'),
(9, 'M1 Chimie'),
(10, 'M2 Chimie'),
(11, 'L1 Mathématiques'),
(12, 'L2 Mathématiques'),
(13, 'L3 Mathématiques'),
(14, 'M1 Mathématiques'),
(15, 'M2 Mathématiques');

-- --------------------------------------------------------

--
-- Structure de la table `Examens`
--

CREATE TABLE `Examens` (
  `idExamen` int(11) NOT NULL,
  `libelle` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `duree` float NOT NULL,
  `idSalle` int(11) NOT NULL,
  `idExamenType` int(11) NOT NULL,
  `date` datetime NOT NULL,
  `idPromotion` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `Examens`
--

INSERT INTO `Examens` (`idExamen`, `libelle`, `duree`, `idSalle`, `idExamenType`, `date`, `idPromotion`) VALUES
(2, 'Algorithmique et Programmation Objet', 120, 17, 1, '2020-12-21 07:30:00', 1),
(3, 'Calculus et Raisonnement', 30, 38, 2, '2020-12-21 15:25:00', 1),
(4, 'Mécanique du Point', 60, 37, 2, '2020-12-14 12:56:00', 1),
(5, 'Electrostatique et Electrocinétique', 60, 39, 2, '2020-12-26 16:57:00', 1),
(6, 'Anglais', 60, 51, 1, '2020-12-14 22:57:20', 1),
(7, 'Bases de Données et Programmation Web', 60, 48, 1, '2020-12-15 22:57:25', 1),
(8, 'Logique pour l’Informatique', 60, 8, 2, '2020-12-24 11:44:39', 1),
(9, 'Programmation Fonctionnelle', 60, 7, 2, '2020-12-14 14:57:34', 1),
(10, 'Interrogation des bases de données', 30, 17, 1, '2020-12-08 13:20:43', 1),
(11, 'Architecture des Ordinateurs', 120, 14, 1, '2020-12-09 16:32:53', 1),
(12, 'Systèmes d’Exploitation', 90, 18, 1, '2020-12-01 08:57:49', 1),
(13, 'Principes de Base des Réseaux', 90, 11, 1, '2020-12-08 22:58:05', 1);

-- --------------------------------------------------------

--
-- Structure de la table `ExamenTypes`
--

CREATE TABLE `ExamenTypes` (
  `idExamenType` int(11) NOT NULL,
  `libelle` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `ExamenTypes`
--

INSERT INTO `ExamenTypes` (`idExamenType`, `libelle`) VALUES
(1, 'CC'),
(2, 'Partiel');

-- --------------------------------------------------------

--
-- Structure de la table `Personnels`
--

CREATE TABLE `Personnels` (
  `idPersonnel` int(11) NOT NULL,
  `nom` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `prenom` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `mdp` varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL,
  `idTypePersonnel` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `Personnels`
--

INSERT INTO `Personnels` (`idPersonnel`, `nom`, `prenom`, `email`, `mdp`, `idTypePersonnel`) VALUES
(1, '', '', 'kailee_christiansen@gmail.com', '+SYcR~$K$L!=s3Dh>=CMrETs7\\/H', 0),
(2, '', '', 'edward.crist@hotmail.com', '+SYcR~$K$L!=s3Dh>=CMrETs7\\/H', 0),
(3, '', '', 'emiliano_oconnell73@hotmail.com', 'A6-cC~#d=s)bpjMhXQ`@H5]Ne$sH', 0),
(4, '', '', 'dayna.kerluke9@yahoo.com', 'A6-cC~#d=s)bpjMhXQ`@H5]Ne$sH', 0),
(5, '', '', 'antonio31@gmail.com', 'A6-cC~#d=s)bpjMhXQ`@H5]Ne$sH', 0),
(6, '', '', 'cyril.fay@gmail.com', 'A6-cC~#d=s)bpjMhXQ`@H5]Ne$sH', 0),
(7, '', '', 'mitchell.braun50@yahoo.com', 'A6-cC~#d=s)bpjMhXQ`@H5]Ne$sH', 0),
(8, '', '', 'liliane_fadel@yahoo.com', 'A6-cC~#d=s)bpjMhXQ`@H5]Ne$sH', 0),
(9, '', '', 'betty.funk@hotmail.com', 'A6-cC~#d=s)bpjMhXQ`@H5]Ne$sH', 0),
(10, '', '', 'irving_schiller@gmail.com', 'A6-cC~#d=s)bpjMhXQ`@H5]Ne$sH', 0),
(11, '', '', 'joel.muller@hotmail.com', 'A6-cC~#d=s)bpjMhXQ`@H5]Ne$sH', 0),
(12, '', '', 'clay.anderson51@hotmail.com', 'A6-cC~#d=s)bpjMhXQ`@H5]Ne$sH', 0),
(13, '', '', 'kassandra.lockman@gmail.com', 'A6-cC~#d=s)bpjMhXQ`@H5]Ne$sH', 0),
(14, '', '', 'conrad98@gmail.com', 'A6-cC~#d=s)bpjMhXQ`@H5]Ne$sH', 0),
(15, '', '', 'josue.oconnell@hotmail.com', 'A6-cC~#d=s)bpjMhXQ`@H5]Ne$sH', 0),
(16, 'Rapha', 'Robenson', 'robenson.dragoon2000@hotmail.fr', '$2a$12$KFy/25KnVTezW8vfKW1k2eXXIYS2KaU9HRRrlmDAyBKrIgUgkkH8m', 3),
(17, 'Lefrere', 'Tom', 'Codect', '$2a$12$LEbHM70.CyaRJGSjMbxtruk5XuYUc5N68eQn9YjpxwlMmvAluIAq6', 3),
(18, 'Er4goon', 'Er4goon', 'Er4goon', '$2a$12$mDP4JWY22PvDd9CirTgeKO9kWFpZWxx3L.oWPPiKF39ubqDlThNby', 3),
(19, 'Lambda', 'Durand', 'Durand@duranf.fr', '$2a$12$XvAHYBr3PDnIA3Hx.42IIegfSOL88k13wn/iT6wx4ajB3sPUMKbue', 1);

-- --------------------------------------------------------

--
-- Structure de la table `Programme`
--

CREATE TABLE `Programme` (
  `idExamen` int(11) NOT NULL,
  `idPersonnel` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `Programme`
--

INSERT INTO `Programme` (`idExamen`, `idPersonnel`) VALUES
(2, 5),
(3, 6),
(5, 4),
(6, 9),
(7, 14),
(8, 2),
(10, 2),
(11, 12);

-- --------------------------------------------------------

--
-- Structure de la table `Responsables`
--

CREATE TABLE `Responsables` (
  `idResponsable` int(11) NOT NULL,
  `nom` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `prenom` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `Responsables`
--

INSERT INTO `Responsables` (`idResponsable`, `nom`, `prenom`) VALUES
(1, 'Mcrae', 'Renato '),
(2, 'Bowers', 'Kiara '),
(3, 'Kaur', 'Ludie '),
(4, 'Mackenzie', 'Lizeth '),
(5, 'Mcnamara', 'Darell '),
(6, 'Mitchell', 'Elvia '),
(7, 'Major', 'Magaly '),
(8, 'Crisp', 'Star'),
(9, 'Farrington', 'Jaimie '),
(10, 'Macfarlane', 'Fleta ');

-- --------------------------------------------------------

--
-- Structure de la table `Salles`
--

CREATE TABLE `Salles` (
  `idSalle` int(11) NOT NULL,
  `libelle` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `capacite` int(11) NOT NULL,
  `idType` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `Salles`
--

INSERT INTO `Salles` (`idSalle`, `libelle`, `capacite`, `idType`) VALUES
(1, 'A-10', 150, 2),
(2, 'A-30', 55, 2),
(3, 'A-40', 50, 2),
(4, 'A-50', 60, 2),
(5, 'E-010', 9, 5),
(6, 'E-020', 15, 1),
(7, 'E-030', 100, 2),
(8, 'E-040 ', 60, 2),
(9, 'E-1000', 17, 1),
(10, 'E-1010', 20, 1),
(11, 'E-1020', 20, 1),
(12, 'E-1030', 16, 6),
(13, 'E-1040', 21, 7),
(14, 'E-1050', 20, 1),
(15, 'E-1060', 20, 1),
(16, 'E-1070', 22, 1),
(17, 'E-1080', 20, 1),
(18, 'E-1090', 13, 1),
(19, 'E-1100', 22, 1),
(20, 'E-2000', 12, 8),
(21, 'E-2010', 20, 1),
(22, 'E-2020', 20, 1),
(23, 'E-2030', 16, 9),
(24, 'E-2040', 20, 1),
(25, 'E-2050', 25, 1),
(26, 'E-2060', 6, 10),
(27, 'E-2070', 11, 1),
(28, 'E-2080', 20, 1),
(29, 'E-2090', 20, 1),
(30, 'E-2100', 21, 1),
(31, 'E-2110', 10, 1),
(32, 'F-120', 29, 1),
(33, 'F-121', 31, 1),
(34, 'F-122', 37, 1),
(35, 'F-123', 30, 1),
(37, 'F-20', 30, 1),
(38, 'F-21', 120, 3),
(39, 'F-22', 120, 3),
(40, 'F-23', 32, 1),
(41, 'F-B', 80, 3),
(42, 'F-P', 100, 3),
(43, 'L-0010', 20, 2),
(44, 'L-0020', 20, 2),
(45, 'L-0040', 20, 2),
(46, 'L-0050', 20, 2),
(47, 'L-0060', 12, 2),
(48, 'L-0080', 20, 2),
(49, 'L-0090', 20, 2),
(50, 'L-0100', 24, 1),
(51, 'L-0110', 24, 11),
(52, 'L-0120', 30, 11),
(53, 'L-0130', 21, 12),
(54, 'L-0140', 29, 11),
(55, 'L-0150', 23, 11),
(56, 'L-0160', 25, 4),
(57, 'L-1110', 23, 1),
(58, 'L-1120', 24, 1),
(59, 'L-1130', 28, 1),
(60, 'L-1140', 23, 11),
(61, 'L-1150', 20, 2),
(62, 'L-1160', 28, 1),
(63, 'L-1170', 20, 2),
(64, 'L-1180', 0, 4),
(89, 'L-2110', 12, 5),
(92, 'L-3000', 95, 3),
(94, 'Test', 58, 1),
(99, 'C-842', 45, 2);

-- --------------------------------------------------------

--
-- Structure de la table `SalleTypes`
--

CREATE TABLE `SalleTypes` (
  `idType` int(11) NOT NULL,
  `libelle` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `SalleTypes`
--

INSERT INTO `SalleTypes` (`idType`, `libelle`) VALUES
(1, 'Salle'),
(2, 'Informatique'),
(3, 'Amphitheatre'),
(4, 'CRL'),
(5, 'Reunion'),
(6, 'M2 Gout'),
(7, 'IP Analyse Sens'),
(8, 'Mathematiques'),
(9, 'M2 Materiaux'),
(10, 'Formation'),
(11, 'Anglais'),
(12, 'These'),
(13, 'PA');

-- --------------------------------------------------------

--
-- Structure de la table `Surveille`
--

CREATE TABLE `Surveille` (
  `idResponsable` int(11) NOT NULL,
  `idExamen` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `Surveille`
--

INSERT INTO `Surveille` (`idResponsable`, `idExamen`) VALUES
(1, 4),
(2, 2),
(3, 7),
(4, 5),
(5, 8),
(6, 13),
(7, 10),
(8, 6),
(9, 11);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `ALieuAvant`
--
ALTER TABLE `ALieuAvant`
  ADD PRIMARY KEY (`idExamen`,`idExamen_Examens`),
  ADD KEY `aLieuAvant_Examens0_FK` (`idExamen_Examens`);

--
-- Index pour la table `Concerne`
--
ALTER TABLE `Concerne`
  ADD PRIMARY KEY (`idEtuListe`,`idExamen`),
  ADD KEY `concerne_Examens0_FK` (`idExamen`);

--
-- Index pour la table `Etudiants`
--
ALTER TABLE `Etudiants`
  ADD PRIMARY KEY (`numEtu`),
  ADD KEY `Etudiants_EtuListes_FK` (`idEtuListe`);

--
-- Index pour la table `EtuListes`
--
ALTER TABLE `EtuListes`
  ADD PRIMARY KEY (`idEtuListe`);

--
-- Index pour la table `Examens`
--
ALTER TABLE `Examens`
  ADD PRIMARY KEY (`idExamen`),
  ADD KEY `Examens_Salles_FK` (`idSalle`),
  ADD KEY `Examens_ExamenTypes0_FK` (`idExamenType`);

--
-- Index pour la table `ExamenTypes`
--
ALTER TABLE `ExamenTypes`
  ADD PRIMARY KEY (`idExamenType`);

--
-- Index pour la table `Personnels`
--
ALTER TABLE `Personnels`
  ADD PRIMARY KEY (`idPersonnel`);

--
-- Index pour la table `Programme`
--
ALTER TABLE `Programme`
  ADD PRIMARY KEY (`idExamen`,`idPersonnel`),
  ADD KEY `programme_Personnels0_FK` (`idPersonnel`);

--
-- Index pour la table `Responsables`
--
ALTER TABLE `Responsables`
  ADD PRIMARY KEY (`idResponsable`);

--
-- Index pour la table `Salles`
--
ALTER TABLE `Salles`
  ADD PRIMARY KEY (`idSalle`),
  ADD KEY `Salles_SalleTypes_FK` (`idType`);

--
-- Index pour la table `SalleTypes`
--
ALTER TABLE `SalleTypes`
  ADD PRIMARY KEY (`idType`);

--
-- Index pour la table `Surveille`
--
ALTER TABLE `Surveille`
  ADD PRIMARY KEY (`idResponsable`,`idExamen`),
  ADD KEY `surveille_Examens0_FK` (`idExamen`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `EtuListes`
--
ALTER TABLE `EtuListes`
  MODIFY `idEtuListe` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;

--
-- AUTO_INCREMENT pour la table `Examens`
--
ALTER TABLE `Examens`
  MODIFY `idExamen` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT pour la table `ExamenTypes`
--
ALTER TABLE `ExamenTypes`
  MODIFY `idExamenType` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `Personnels`
--
ALTER TABLE `Personnels`
  MODIFY `idPersonnel` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT pour la table `Responsables`
--
ALTER TABLE `Responsables`
  MODIFY `idResponsable` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT pour la table `Salles`
--
ALTER TABLE `Salles`
  MODIFY `idSalle` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=100;

--
-- AUTO_INCREMENT pour la table `SalleTypes`
--
ALTER TABLE `SalleTypes`
  MODIFY `idType` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `ALieuAvant`
--
ALTER TABLE `ALieuAvant`
  ADD CONSTRAINT `aLieuAvant_Examens0_FK` FOREIGN KEY (`idExamen_Examens`) REFERENCES `Examens` (`idExamen`),
  ADD CONSTRAINT `aLieuAvant_Examens_FK` FOREIGN KEY (`idExamen`) REFERENCES `Examens` (`idExamen`);

--
-- Contraintes pour la table `Concerne`
--
ALTER TABLE `Concerne`
  ADD CONSTRAINT `concerne_EtuListes_FK` FOREIGN KEY (`idEtuListe`) REFERENCES `EtuListes` (`idEtuListe`),
  ADD CONSTRAINT `concerne_Examens0_FK` FOREIGN KEY (`idExamen`) REFERENCES `Examens` (`idExamen`);

--
-- Contraintes pour la table `Etudiants`
--
ALTER TABLE `Etudiants`
  ADD CONSTRAINT `Etudiants_EtuListes_FK` FOREIGN KEY (`idEtuListe`) REFERENCES `EtuListes` (`idEtuListe`);

--
-- Contraintes pour la table `Examens`
--
ALTER TABLE `Examens`
  ADD CONSTRAINT `Examens_ExamenTypes0_FK` FOREIGN KEY (`idExamenType`) REFERENCES `ExamenTypes` (`idExamenType`),
  ADD CONSTRAINT `Examens_Salles_FK` FOREIGN KEY (`idSalle`) REFERENCES `Salles` (`idSalle`);

--
-- Contraintes pour la table `Programme`
--
ALTER TABLE `Programme`
  ADD CONSTRAINT `programme_Examens_FK` FOREIGN KEY (`idExamen`) REFERENCES `Examens` (`idExamen`),
  ADD CONSTRAINT `programme_Personnels0_FK` FOREIGN KEY (`idPersonnel`) REFERENCES `Personnels` (`idPersonnel`);

--
-- Contraintes pour la table `Salles`
--
ALTER TABLE `Salles`
  ADD CONSTRAINT `Salles_SalleTypes_FK` FOREIGN KEY (`idType`) REFERENCES `SalleTypes` (`idType`);

--
-- Contraintes pour la table `Surveille`
--
ALTER TABLE `Surveille`
  ADD CONSTRAINT `surveille_Examens0_FK` FOREIGN KEY (`idExamen`) REFERENCES `Examens` (`idExamen`),
  ADD CONSTRAINT `surveille_Responsables_FK` FOREIGN KEY (`idResponsable`) REFERENCES `Responsables` (`idResponsable`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
