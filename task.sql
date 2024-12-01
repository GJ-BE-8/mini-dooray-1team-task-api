CREATE TABLE `projects` (
	`id`	bigint	NOT NULL	COMMENT 'auto-increment',
	`name`	varchar(100)	NOT NULL,
	`state`	enum('ACTIVATION', 'DORMANT', 'END')	NOT NULL
);

CREATE TABLE `comment` (
	`id`	bigint	NOT NULL	COMMENT 'auto-increment',
	`contents`	varchar(100)	NOT NULL,
	`created_at`	datetime	NOT NULL,
	`task_id`	bigint	NOT NULL,
	`id2`	bigint	NOT NULL	COMMENT 'auto-increment'
);

CREATE TABLE `task` (
	`id`	bigint	NOT NULL	COMMENT 'auto-increment',
	`title`	varchar(20)	NOT NULL,
	`contents`	text	NULL,
	`project_id`	bigint	NOT NULL,
	`project_member_id`	bigint	NOT NULL,
	`id3`	bigint	NOT NULL	COMMENT 'auto-increment',
	`id2`	bigint	NOT NULL	COMMENT 'auto-increment',
	`contents2`	varchar(50)	NOT NULL
);

CREATE TABLE `milestone` (
	`id`	bigint	NOT NULL	COMMENT 'auto-increment',
	`contents`	varchar(50)	NOT NULL,
	`id2`	bigint	NOT NULL	COMMENT 'auto-increment'
);

CREATE TABLE `projects_members` (
	`id`	bigint	NOT NULL	COMMENT 'auto-increment',
	`name`	varchar(50)	NOT NULL,
	`email`	varchar(100)	NOT NULL,
	`auth`	enum('ADMIM', 'MEMBER')	NOT NULL,
	`projects_id`	bigint	NOT NULL
);

CREATE TABLE `tag` (
	`id`	bigint	NOT NULL	COMMENT 'auto-increment',
	`name`	varchar(50)	NOT NULL,
	`project_id`	bigint	NOT NULL
);

ALTER TABLE `projects` ADD CONSTRAINT `PK_PROJECTS` PRIMARY KEY (
	`id`
);

ALTER TABLE `comment` ADD CONSTRAINT `PK_COMMENT` PRIMARY KEY (
	`id`
);

ALTER TABLE `task` ADD CONSTRAINT `PK_TASK` PRIMARY KEY (
	`id`
);

ALTER TABLE `milestone` ADD CONSTRAINT `PK_MILESTONE` PRIMARY KEY (
	`id`
);

ALTER TABLE `projects_members` ADD CONSTRAINT `PK_PROJECTS_MEMBERS` PRIMARY KEY (
	`id`
);

ALTER TABLE `tag` ADD CONSTRAINT `PK_TAG` PRIMARY KEY (
	`id`,
	`name`
);
ALTER TABLE `comment` ADD CONSTRAINT `FK_task_TO_comment_1` FOREIGN KEY (
	`task_id`
)
REFERENCES `task` (
	`id`
);

ALTER TABLE `comment` ADD CONSTRAINT `FK_projects_members_TO_comment_1` FOREIGN KEY (
	`id2`
)
REFERENCES `projects_members` (
	`id`
);

ALTER TABLE `task` ADD CONSTRAINT `FK_projects_TO_task_1` FOREIGN KEY (
	`project_id`
)
REFERENCES `projects` (
	`id`
);

ALTER TABLE `task` ADD CONSTRAINT `FK_projects_members_TO_task_1` FOREIGN KEY (
	`project_member_id`
)
REFERENCES `projects_members` (
	`id`
);

ALTER TABLE `task` ADD CONSTRAINT `FK_milestone_TO_task_1` FOREIGN KEY (
	`id3`
)
REFERENCES `milestone` (
	`id`
);

ALTER TABLE `task` ADD CONSTRAINT `FK_tag_TO_task_1` FOREIGN KEY (
	`id2`
)
REFERENCES `tag` (
	`id`
);

ALTER TABLE `task` ADD CONSTRAINT `FK_tag_TO_task_2` FOREIGN KEY (
	`contents2`
)
REFERENCES `tag` (
	`name`
);

ALTER TABLE `milestone` ADD CONSTRAINT `FK_projects_TO_milestone_1` FOREIGN KEY (
	`id2`
)
REFERENCES `projects` (
	`id`
);

ALTER TABLE `projects_members` ADD CONSTRAINT `FK_projects_TO_projects_members_1` FOREIGN KEY (
	`projects_id`
)
REFERENCES `projects` (
	`id`
);

ALTER TABLE `tag` ADD CONSTRAINT `FK_projects_TO_tag_1` FOREIGN KEY (
	`project_id`
)
REFERENCES `projects` (
	`id`
);
