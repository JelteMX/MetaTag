define([
    "dojo/_base/declare",
    "mxui/widget/_WidgetBase",

    "mxui/dom",
    "dojo/dom",
    "dojo/dom-prop",
    "dojo/dom-geometry",
    "dojo/dom-class",
    "dojo/dom-style",
    "dojo/dom-construct",
    "dojo/_base/array",
    "dojo/_base/lang",
    "dojo/text",
    "dojo/html",
    "dojo/_base/event",


], function (declare, _WidgetBase, dom, dojoDom, dojoProp, dojoGeometry, dojoClass, dojoStyle, dojoConstruct, dojoArray, lang, dojoText, dojoHtml, dojoEvent) {
    "use strict";

    return declare("MetaTag.widget.MetaTag", [ _WidgetBase ], {

        // Variables within this widget
        arrNewElements: null,

        constructor: function () {

        },

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

            this._contextObj = obj;
            this._updateRendering(callback);
        },

        resize: function (box) {
          logger.debug(this.id + ".resize");
        },

        uninitialize: function () {
          logger.debug(this.id + ".uninitialize");
          logger.debug("remove meta elements: " + this.arrNewElements.length);

          for (var j = 0; j < this.arrNewElements.length; j++) {
            document.head.removeChild(this.arrNewElements[j]);
          } 
        },

        _updateRendering: function (callback) {
            logger.debug(this.id + "._updateRendering");

            if (this._contextObj !== null) {
                dojoStyle.set(this.domNode, "display", "block");
            } else {
                dojoStyle.set(this.domNode, "display", "none");
            }

            this._executeCallback(callback, "_updateRendering");
        },

        // Shorthand for running a microflow
        _execMf: function (mf, guid, cb) {
            logger.debug(this.id + "._execMf");
            if (mf && guid) {
                mx.ui.action(mf, {
                    params: {
                        applyto: "selection",
                        guids: [guid]
                    },
                    callback: lang.hitch(this, function (objs) {
                        if (cb && typeof cb === "function") {
                            cb(objs);
                        }
                    }),
                    error: function (error) {
                        console.debug(error.description);
                    }
                }, this);
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
