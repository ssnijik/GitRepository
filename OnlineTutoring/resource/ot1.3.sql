SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `onlinetutoring` ;
CREATE SCHEMA IF NOT EXISTS `onlinetutoring` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `onlinetutoring` ;

-- -----------------------------------------------------
-- Table `onlinetutoring`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `onlinetutoring`.`user` ;

CREATE  TABLE IF NOT EXISTS `onlinetutoring`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(30) NULL ,
  `last_name` VARCHAR(30) NULL ,
  `email` VARCHAR(60) NOT NULL ,
  `password` VARCHAR(30) NOT NULL ,
  `phone` VARCHAR(15) NULL ,
  `birthday` DATE NULL ,
  `card_num` VARCHAR(16) NULL ,
  `type` CHAR(1) NOT NULL ,
  `point` INT NULL DEFAULT 0 ,
  `head_pic_sn` VARCHAR(10) NULL ,
  `school` VARCHAR(20) NULL ,
  `cookie_sn` VARCHAR(20) NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) ,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `onlinetutoring`.`subject`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `onlinetutoring`.`subject` ;

CREATE  TABLE IF NOT EXISTS `onlinetutoring`.`subject` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(20) NOT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `onlinetutoring`.`question`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `onlinetutoring`.`question` ;

CREATE  TABLE IF NOT EXISTS `onlinetutoring`.`question` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL ,
  `title` VARCHAR(30) NOT NULL ,
  `content` VARCHAR(1000) NOT NULL ,
  `time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ,
  `view` INT NOT NULL DEFAULT 0 ,
  `pic_sn` VARCHAR(10) NULL ,
  `attachment_sn` VARCHAR(10) NULL ,
  `subject_id` INT NOT NULL ,
  `reply` INT NOT NULL DEFAULT 0 ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `picSn_UNIQUE` (`pic_sn` ASC) ,
  UNIQUE INDEX `attachmentSn_UNIQUE` (`attachment_sn` ASC) ,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) ,
  INDEX `authorId_idx` (`user_id` ASC) ,
  INDEX `fk_que_sub_id_idx` (`subject_id` ASC) ,
  CONSTRAINT `fk_que_per_id`
    FOREIGN KEY (`user_id` )
    REFERENCES `onlinetutoring`.`user` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_que_sub_id`
    FOREIGN KEY (`subject_id` )
    REFERENCES `onlinetutoring`.`subject` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `onlinetutoring`.`answer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `onlinetutoring`.`answer` ;

CREATE  TABLE IF NOT EXISTS `onlinetutoring`.`answer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL ,
  `content` VARCHAR(1000) NOT NULL ,
  `time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ,
  `question_id` INT NOT NULL ,
  `pic_sn` VARCHAR(10) NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) ,
  INDEX `questionId_idx` (`question_id` ASC) ,
  INDEX `authorId_idx` (`user_id` ASC) ,
  UNIQUE INDEX `question_id_UNIQUE` (`question_id` ASC) ,
  CONSTRAINT `fk_ans_per_id`
    FOREIGN KEY (`user_id` )
    REFERENCES `onlinetutoring`.`user` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ans_que_id`
    FOREIGN KEY (`question_id` )
    REFERENCES `onlinetutoring`.`question` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `onlinetutoring`.`notification`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `onlinetutoring`.`notification` ;

CREATE  TABLE IF NOT EXISTS `onlinetutoring`.`notification` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `notification_id` INT NOT NULL ,
  `user_id` INT NOT NULL ,
  `type` INT NOT NULL ,
  `time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) ,
  INDEX `_idx` (`user_id` ASC) ,
  CONSTRAINT `fk_not_per_id`
    FOREIGN KEY (`user_id` )
    REFERENCES `onlinetutoring`.`user` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `onlinetutoring`.`tutor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `onlinetutoring`.`tutor` ;

CREATE  TABLE IF NOT EXISTS `onlinetutoring`.`tutor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL ,
  `balance` INT NULL ,
  `description` VARCHAR(1000) NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `personId_UNIQUE` (`user_id` ASC) ,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) ,
  CONSTRAINT `fk_tut_per_id`
    FOREIGN KEY (`user_id` )
    REFERENCES `onlinetutoring`.`user` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `onlinetutoring`.`student`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `onlinetutoring`.`student` ;

CREATE  TABLE IF NOT EXISTS `onlinetutoring`.`student` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL ,
  `grade` INT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `personId_UNIQUE` (`user_id` ASC) ,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) ,
  CONSTRAINT `fk_stu_per_id`
    FOREIGN KEY (`user_id` )
    REFERENCES `onlinetutoring`.`user` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `onlinetutoring`.`friend`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `onlinetutoring`.`friend` ;

CREATE  TABLE IF NOT EXISTS `onlinetutoring`.`friend` (
  `id_a` INT NOT NULL ,
  `id_b` INT NOT NULL ,
  PRIMARY KEY (`id_a`, `id_b`) ,
  INDEX `fk_fri_b_per_id_idx` (`id_b` ASC) ,
  INDEX `fk_fri_a_per_id_idx` (`id_a` ASC) ,
  CONSTRAINT `fk_fri_a_per_id`
    FOREIGN KEY (`id_a` )
    REFERENCES `onlinetutoring`.`user` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_fri_b_per_id`
    FOREIGN KEY (`id_b` )
    REFERENCES `onlinetutoring`.`user` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `onlinetutoring`.`message`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `onlinetutoring`.`message` ;

CREATE  TABLE IF NOT EXISTS `onlinetutoring`.`message` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `sender_id` INT NOT NULL ,
  `receiver_id` INT NOT NULL ,
  `content` VARCHAR(200) NOT NULL ,
  `time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) ,
  INDEX `toId_idx` (`receiver_id` ASC) ,
  INDEX `fromId_idx` (`sender_id` ASC) ,
  CONSTRAINT `fk_mes_sen_per_id`
    FOREIGN KEY (`sender_id` )
    REFERENCES `onlinetutoring`.`user` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_mes_rec_per_id`
    FOREIGN KEY (`receiver_id` )
    REFERENCES `onlinetutoring`.`user` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `onlinetutoring`.`course`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `onlinetutoring`.`course` ;

CREATE  TABLE IF NOT EXISTS `onlinetutoring`.`course` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `start_time` DATETIME NOT NULL ,
  `end_time` DATETIME NOT NULL ,
  `duration` INT NOT NULL ,
  `student_id` INT NULL ,
  `tutor_id` INT NOT NULL ,
  `price` INT NOT NULL DEFAULT 0 ,
  `name` VARCHAR(45) NOT NULL ,
  `description` VARCHAR(1000) NOT NULL ,
  `subject_id` INT NOT NULL ,
  `eval_by_tutor_a` INT NOT NULL DEFAULT 0 ,
  `eval_by_tutor_b` INT NOT NULL DEFAULT 0 ,
  `eval_by_tutor_c` INT NOT NULL DEFAULT 0 ,
  `eval_by_stu_a` INT NOT NULL DEFAULT 0 ,
  `eval_by_stu_b` INT NOT NULL DEFAULT 0 ,
  `eval_by_stu_c` INT NOT NULL DEFAULT 0 ,
  `evaluation` VARCHAR(1000) NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) ,
  INDEX `fk_cou_sub_id_idx` (`subject_id` ASC) ,
  INDEX `fk_cou_stu_per_id_idx` (`student_id` ASC) ,
  INDEX `fk_cou_tut_per_id_idx` (`tutor_id` ASC) ,
  CONSTRAINT `fk_cou_stu_per_id`
    FOREIGN KEY (`student_id` )
    REFERENCES `onlinetutoring`.`student` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cou_tut_per_id`
    FOREIGN KEY (`tutor_id` )
    REFERENCES `onlinetutoring`.`tutor` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cou_sub_id`
    FOREIGN KEY (`subject_id` )
    REFERENCES `onlinetutoring`.`subject` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `onlinetutoring`.`application`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `onlinetutoring`.`application` ;

CREATE  TABLE IF NOT EXISTS `onlinetutoring`.`application` (
  `course_id` INT NOT NULL ,
  `student_id` INT NOT NULL ,
  PRIMARY KEY (`course_id`, `student_id`) ,
  INDEX `courseId_idx` (`course_id` ASC) ,
  INDEX `fk_app_stu_id_idx` (`student_id` ASC) ,
  CONSTRAINT `fk_app_cou_id`
    FOREIGN KEY (`course_id` )
    REFERENCES `onlinetutoring`.`course` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_app_stu_id`
    FOREIGN KEY (`student_id` )
    REFERENCES `onlinetutoring`.`student` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `onlinetutoring`.`specialty`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `onlinetutoring`.`specialty` ;

CREATE  TABLE IF NOT EXISTS `onlinetutoring`.`specialty` (
  `tutor_id` INT NOT NULL ,
  `subject_id` INT NOT NULL ,
  INDEX `fk_spe_sub_id_idx` (`subject_id` ASC) ,
  PRIMARY KEY (`tutor_id`, `subject_id`) ,
  CONSTRAINT `fk_spe_tut_id`
    FOREIGN KEY (`tutor_id` )
    REFERENCES `onlinetutoring`.`tutor` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_spe_sub_id`
    FOREIGN KEY (`subject_id` )
    REFERENCES `onlinetutoring`.`subject` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `onlinetutoring` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;