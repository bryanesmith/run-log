#
# TODO: Duplication with /terraform/staging/variables.tf
#

# Required
# - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
variable "aws_region"               {}
variable "cors_allowed_origins"     {}
variable "dynamodb_table"           {}
variable "run_log_version"          {}
variable "s3_bucket_stage_assets"   {} # TODO: rename s3_bucket_staging
variable "s3_bucket_web"            {}

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
