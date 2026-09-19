package com.ask.printersdk.ui;

import androidx.lifecycle.ViewModel;
import com.ask.printersdk.graph.Graph;
import com.ask.printersdk.graph.common.DrawingSurfaceView;
import com.ask.printersdk.graph.common.GraphManger;
import com.ask.printersdk.graph.common.GraphOpCallback;

/* JADX INFO: loaded from: classes2.dex */
public class PrintEditViewModel extends ViewModel {
    Graph curGraph;
    public DrawingSurfaceView drawingSurfaceView;

    public GraphManger getGraphManger() {
        return this.drawingSurfaceView.getGraphManger();
    }

    public void addBitmap(String str) {
        getGraphManger().addBitmapGraph(str, null);
    }

    public void addText(String str) {
        getGraphManger().addTextGraph(str);
    }

    public void setGraphOpCallback(GraphOpCallback graphOpCallback) {
        this.drawingSurfaceView.setGraphOpCallback(new GraphOpCallbackWarp(graphOpCallback));
    }

    class GraphOpCallbackWarp implements GraphOpCallback {
        GraphOpCallback graphOpCallback;

        GraphOpCallbackWarp(GraphOpCallback graphOpCallback) {
            this.graphOpCallback = graphOpCallback;
        }

        @Override // com.ask.printersdk.graph.common.GraphOpCallback
        public void onSelected(Graph graph) {
            if (graph != PrintEditViewModel.this.curGraph) {
                PrintEditViewModel.this.curGraph = graph;
                this.graphOpCallback.onSelected(graph);
            } else {
                PrintEditViewModel.this.curGraph = graph;
            }
        }

        @Override // com.ask.printersdk.graph.common.GraphOpCallback
        public void onDrawingBoardChanged() {
            this.graphOpCallback.onDrawingBoardChanged();
        }

        @Override // com.ask.printersdk.graph.common.GraphOpCallback
        public void opStateChange(int i, int i2) {
            this.graphOpCallback.opStateChange(i, i2);
        }
    }
}
