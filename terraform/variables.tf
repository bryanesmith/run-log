# Required
# - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
variable "aws_region"               {}
variable "cors_allowed_origins"     {}
variable "dynamodb_table"           {}
variable "run_log_version"          {}
variable "s3_bucket_stage_assets"   {}

# Optional
# - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
variable "common_tags"              {
  default = {
    Name = "run-log"
    Environment = "production" # TODO: duplicates var.environment
    ManagedBy = "Terraform"
  }
}
variable "environment"              {
  default = "production"
}
