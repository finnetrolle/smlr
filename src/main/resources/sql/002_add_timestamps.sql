BEGIN TRANSACTION;

ALTER TABLE "links" ADD COLUMN created timestamp with time zone NOT NULL DEFAULT "now"();

END TRANSACTION;