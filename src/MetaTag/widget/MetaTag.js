define([
    "dojo/_base/declare",
    "mxui/widget/_WidgetBase"
], function (declare, _WidgetBase) {
    "use strict";

    return declare("MetaTag.widget.MetaTag", [ _WidgetBase ], {

        // Variables within this widget
        arrNewElements: null,

        postCreate: function () {
            logger.debug(this.id + ".postCreate");

            this.arrNewElements = []; 

            // Process the generic meta data tags and create the meta elements
            this._createMetaElements(this.metaData, false);

            // Process the open graph data specific tags and create the meta elements
            this._createMetaElements(this.ogData, true);

            logger.debug(this.arrNewElements);
        },

        update: function (obj, callback) {
            logger.debug(this.id + ".update");
            this._executeCallback(callback, "update");
        },

        resize: function (box) {
            // Keep this in, does not do anything
        },

        uninitialize: function () {
            logger.debug(this.id + ".uninitialize");
            logger.debug("remove meta elements: " + this.arrNewElements.length);

            for (var j = 0; j < this.arrNewElements.length; j++) {
                document.head.removeChild(this.arrNewElements[j]);
            } 
        },

        // Shorthand for executing a callback, adds logging to your inspector
        _executeCallback: function (cb, from) {
            logger.debug(this.id + "._executeCallback" + (from ? " from " + from : ""));
            if (cb && typeof cb === "function") {
                cb();
            }
        },

        _createMetaElements: function (tagData, isOGdata) {
            this.tagData = tagData;
            this.isOGdata = isOGdata;

            for (var i = 0; i < this.tagData.length; i++) {             
                var newElement = document.createElement("meta");
                var newAttributeProperty = null; 
                var newAttributeContent = document.createAttribute("content");
                
                if(this.isOGdata) {
                    newAttributeProperty = document.createAttribute("property");
                    newAttributeProperty.value = "og:"+this.tagData[i].tagName;
                } else {
                    newAttributeProperty = document.createAttribute("name");
                    newAttributeProperty.value = this.tagData[i].tagName;
                }

                newAttributeContent.value = this.tagData[i].tagValue;
                newElement.setAttributeNode(newAttributeProperty);
                newElement.setAttributeNode(newAttributeContent);

                document.head.appendChild(newElement);

                this.arrNewElements.push(newElement);
            }
        }
    });
});

require(["MetaTag/widget/MetaTag"]);
