variable "aws_region"               {}
variable "cors_allowed_origins"     {}
variable "dynamodb_table"           {}
variable "run_log_version"          {}
variable "s3_bucket_stage_assets"   {}

variable "common_tags"              {
  default = {
    Name = "run-log"
    Environment = "production"
    ManagedBy = "Terraform"
  }
}
