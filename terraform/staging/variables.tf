#
# TODO: Duplication with /terraform/infrastructure/variables.tf
#

# Required
# - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
variable "aws_region"               {}
variable "staging_bucket_name"      {}

# Optional
# - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
variable "common_tags"              {
  default = {
    Name = "run-log"
    Environment = "production" # TODO: duplicates var.environment
    ManagedBy = "Terraform"
  }
}
