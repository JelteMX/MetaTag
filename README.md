# MetaTag
This Mendix widget lets you add meta tags to your web pages (generic and og: tags).

## Contributing

For more information on contributing to this repository visit [Contributing to a GitHub repository](https://world.mendix.com/display/howto50/Contributing+to+a+GitHub+repository)!

## Typical usage scenario

* Adding generic meta tags to your Mendix app when it is publicly available or social media platforms are likely to link to the app. 

## Features and limitations

 * No context
 * OG property tagNames are hard-coded prefixed with og:

## Dependencies
* Atleast Mendix 5.19 environment
 
## Properties

Two lists can be created: 
* General Meta tags which takes a "name" and "value" argument. For example set {tagName} to description and {tagValue} to Widget test will generate a tag with: `<meta name="description" content="Widget test">`
* OG meta tags which takes a "property" and "value" argument. For example set {tagName} to title and {tagValue} to FlowFabric website will generate a tag with: `<meta property="og:title" content="FlowFabric website">`
