# Synapx Autonomous Insurance Claims Processing Agent

## Overview
This project is a Java-based agent that processes FNOL (First Notice of Loss) insurance documents.

The system:
- Reads claim documents
- Extracts important fields
- Detects missing information
- Applies routing rules
- Outputs decision in JSON format

## Extracted Fields
- Policy Number
- Incident Date
- Location
- Estimated Damage
- Description

## Routing Rules
- Damage < 25000 → Fast Track
- Missing fields → Manual Review
- Fraud keywords → Investigation
- Injury claims → Specialist Queue

## Technology Used
- Java
- Regex
- Rule-based logic

## Project Structure
src/
Main.java  
PdfReaderUtil.java  
FieldExtractor.java  
Router.java  
ClaimResult.java  

## How it works
1. Read document text
2. Extract fields
3. Validate data
4. Apply rules
5. Generate JSON output

## Author
Synapx Assessment Submission
